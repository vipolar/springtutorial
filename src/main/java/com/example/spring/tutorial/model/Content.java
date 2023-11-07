package com.example.spring.tutorial.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record Content(
    Integer id,
    @NotBlank
    String title,
    String description,
    Status status,
    Type type,
    LocalDate created,
    LocalDate updated,
    String url
) {
    
}
