package com.example.spring.tutorial.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.spring.tutorial.model.Content;
import com.example.spring.tutorial.model.Status;
import com.example.spring.tutorial.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
    
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }
    
    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    //updates are implemented terribly!!
    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void initialData() {
        Content entry1 = new Content(
            1,
            "title example",
            "decription example",
            Status.IDEA,
            Type.ARTICLE,
            LocalDate.now(),
            null,
            ""   
        );

        contentList.add(entry1);
    }
}
