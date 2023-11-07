package com.example.spring.tutorial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.spring.tutorial.model.Content;
import com.example.spring.tutorial.repository.ContentRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/get/all")
    public List<Content> findAll() {
        return repository.findAll();
    }
 
    @GetMapping("/get/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    @ResponseBody
    public String create(@Valid @RequestBody Content content){
        repository.save(content);
        return "Thanks For Posting!!!";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public String update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }

        repository.save(content);
        return "Thanks For Updating!!!";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            repository.deleteById(id);
            return "Thanks For Deleting!!!";
        }

        return "Deleting failed!!!";
    }

    @GetMapping("/get/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

}
