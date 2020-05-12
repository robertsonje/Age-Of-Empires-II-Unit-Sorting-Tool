/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CrudRepository.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author robertsonje
 */
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @GetMapping("/")
    public String index() {
        return "index";
    }    
}
