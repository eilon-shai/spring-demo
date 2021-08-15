package com.imperva.spring.demo.ioc.controllers;

import com.google.gson.GsonBuilder;
import com.imperva.spring.demo.ioc.services.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/person
@Controller
@RequestMapping("/person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger( PersonController.class );

    @Autowired
    IPersonService service;

    @GetMapping(produces = { "application/json" } )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getPerson(@RequestParam Long id){
        return ResponseEntity.ok(new GsonBuilder().create().toJson(service.getPerson(id)));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void newPerson(@RequestParam String name){
        service.createPerson(name);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void editPerson(@RequestParam Long id){
        service.updatePerson(id);
    }


}
