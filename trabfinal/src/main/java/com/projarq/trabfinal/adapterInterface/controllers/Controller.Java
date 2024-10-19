package com.projarq.trabfinal.adapterInterface.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Controller {
    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String getMethodName() {
        return "teste";
    }
}
