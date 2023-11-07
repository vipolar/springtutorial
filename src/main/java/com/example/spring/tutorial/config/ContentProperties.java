package com.example.spring.tutorial.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "cc")
public record ContentProperties(String welcomeMessage) {
    
}
