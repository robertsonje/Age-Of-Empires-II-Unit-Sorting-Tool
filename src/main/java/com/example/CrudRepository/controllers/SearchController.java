package com.example.CrudRepository.controllers;

import com.example.CrudRepository.Model.AjaxResponseBody;
import com.example.CrudRepository.Model.SearchCriteria;
import com.example.CrudRepository.Model.Unit;
import com.example.CrudRepository.Services.UnitService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class SearchController{
    UnitService unitService;
    
    @Autowired
    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
    
    @PostMapping(path="/search")
    public ResponseEntity<AjaxResponseBody> getSearchResultViaAjax(
        @Valid @RequestBody SearchCriteria search, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        
        // Send a 400 bad request upon error
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                .stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
            }
        
        List<Unit> units = unitService.findByUnitName(search.getName());
        if (units.isEmpty()) {
            result.setMsg("No units found under given name");
        } else {
            result.setMsg("Found the following units:");
        }
        result.setResult(units);
        return ResponseEntity.ok(result);
    }
}
