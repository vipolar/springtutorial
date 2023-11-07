package com.example.spring.tutorial.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="content")
public class Content {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private LocalDate created;

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    private LocalDate updated;

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
