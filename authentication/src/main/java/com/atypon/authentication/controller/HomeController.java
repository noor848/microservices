package com.atypon.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/show-results")
    public Boolean showResults(@RequestParam String username, @RequestParam String password){
        if(username != null && password != null &&
                username.equals("Deya") && password.equals("Deya@12@"))
            return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    @GetMapping("/enter-data")
    public Boolean enterData(@RequestParam String username, @RequestParam String password){
        if(username != null && password != null &&
                username.equals("Deya") && password.equals("Deya@12@"))
            return Boolean.TRUE;
        else return Boolean.FALSE;
    }
}
