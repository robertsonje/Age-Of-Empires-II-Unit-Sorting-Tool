/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CrudRepository.Services;
import com.example.CrudRepository.Model.Unit;
import com.example.CrudRepository.Model.UnitCost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author robertsonje
 */
@Service
public class UnitService {
    private List<Unit> units;
    public List<Unit> findByUnitName(String name) {
        List<Unit> result;
        result = units.stream()
                .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        java.util.Collections.sort(result);
        return result;
    }
    
    @PostConstruct
    private void initDataForTesting() {
        final String uri = "https://age-of-empires-2-api.herokuapp.com/api/v1/units";

        units = new ArrayList<Unit>();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            node = mapper.readTree(result);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UnitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        parseJsonForUnitList(node);
        System.out.println(units);
    }
    
    private void parseJsonForUnitList(JsonNode unitJson) {
        if (unitJson != null) {
            JsonNode unitList = unitJson.get("units");
            JsonNode currentUnit = null;
            int i = 0;
            while (unitList.has(i)) {
                currentUnit = unitList.get(i);
                
                int id = currentUnit.get("id") == null ? 0 : currentUnit.get("id").asInt();
                String name = currentUnit.get("name") == null ? "" : (String)currentUnit.get("name").asText();
                String description = currentUnit.get("description") == null ? "" : currentUnit.get("description").asText();
                String expansion = currentUnit.get("expansion") == null ? "" : currentUnit.get("expansion").asText();
                String age = currentUnit.get("age") == null ? "" : currentUnit.get("age").asText();
                String created_in = currentUnit.get("created_in") == null ? "" : currentUnit.get("created_in").asText();
                UnitCost currentUnitCost = 
                        new UnitCost(currentUnit.get("cost").get("Wood"),
                                currentUnit.get("cost").get("Food"),
                                currentUnit.get("cost").get("Stone"),
                                currentUnit.get("cost").get("Gold"));
                int build_time = currentUnit.get("build_time") == null ? 0 : currentUnit.get("build_time").asInt();
                int reload_time = currentUnit.get("reload_time") == null ? 0 : currentUnit.get("reload_time").asInt();
                double attack_delay = currentUnit.get("attack_delay") == null ? 0.0 : currentUnit.get("attack_delay").asDouble();
                double movement_rate = currentUnit.get("movement_rate") == null ? 0.0 : currentUnit.get("movement_rate").asDouble();
                int line_of_sight = currentUnit.get("line_of_sight") == null ? 0 : currentUnit.get("line_of_sight").asInt();
                int hit_points = currentUnit.get("hit_points") == null ? 0 : currentUnit.get("hit_points").asInt();
                int range = currentUnit.get("range") == null ? 0 : currentUnit.get("range").asInt();
                int attack = currentUnit.get("attack") == null ? 0 : currentUnit.get("attack").asInt();
                String armor = currentUnit.get("armor") == null ? "" : currentUnit.get("armor").asText();
                //null,
                //null,
                int search_radius = currentUnit.get("search_radius") == null ? 0 : currentUnit.get("search_radius").asInt();
                String accuracy = currentUnit.get("accuracy") == null ? "0%" : currentUnit.get("accuracy").asText();
                int blast_radius = currentUnit.get("blast_radius") == null ? 0 : currentUnit.get("blast_radius").asInt();
                                
                // Parse by field
                units.add(new Unit(id,
                    name,
                    description,
                    expansion,
                    age,
                    created_in,
                    currentUnitCost,
                    build_time,
                    reload_time,
                    attack_delay,
                    movement_rate,
                    line_of_sight,
                    hit_points,
                    range,
                    attack,
                    armor,
                    null,
                    null,
                    search_radius,
                    accuracy,
                    blast_radius));
                i++;
            }
        }
    }
}
