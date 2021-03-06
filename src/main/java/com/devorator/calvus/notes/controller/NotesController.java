package com.devorator.calvus.notes.controller;


import com.devorator.calvus.notes.database.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DatabaseController databaseController;

    @GetMapping("/hello")
    String HelloWorld() {
        return "<h1>HelloWorld</h1>";
    }

    @GetMapping("/notes")
    void postNote() {
        String json = "{\"name\":\"Thinking in Java\",\"content\":\"I was facing a similar problem today.\"}";
        int noteId = 5;
        databaseController.insert(json);
        databaseController.update(json, noteId);
    }
}




