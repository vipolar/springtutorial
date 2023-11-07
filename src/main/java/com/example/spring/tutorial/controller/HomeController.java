package com.example.spring.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.tutorial.config.ContentProperties;

@RestController
public class HomeController {

    private final ContentProperties contentProperties;

    public HomeController(ContentProperties contentProperties) {
        this.contentProperties = contentProperties;
    }

    @GetMapping("/")
    public ContentProperties home() {
        return contentProperties;
    }
    
}
