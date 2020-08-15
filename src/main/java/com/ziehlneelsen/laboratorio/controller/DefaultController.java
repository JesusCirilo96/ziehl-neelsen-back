package com.ziehlneelsen.laboratorio.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultController {

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET, produces = "application/json")
    public String helloWorld(){
        return "Hello World";
    }
}
