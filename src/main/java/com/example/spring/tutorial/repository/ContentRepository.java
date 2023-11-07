package com.example.spring.tutorial.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.spring.tutorial.model.Content;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    
    List<Content> findAllByTitleContains(String keyword);
}
