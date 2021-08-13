package com.imperva.spring.demo.ioc.controllers;

import com.imperva.spring.demo.ioc.interfaces.RequestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

//http://localhost:8080/demo
@Controller
@RequestMapping("/demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger( DemoController.class );

    @Autowired
    RequestBean requestBean;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void demo(){
        requestBean.toString();
        logger.info("demo was called");
    }


}
