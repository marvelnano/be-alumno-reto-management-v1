package com.example.scotiabankchallenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping({"", "index", "home"})
    public String getHome() {
        return "<h1>Bienvenidos al reto ScotiaBank</h1>";
    }
}
