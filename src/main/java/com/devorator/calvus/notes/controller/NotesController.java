package com.devorator.calvus.notes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotesController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@RequestMapping("/notes")
    String HelloWorld(){
        return "<h1>HelloWorld</h1>";
    }

    public void insertNote(){
        String sql = "INSERT INTO notes (note_NAME, creation_DATE, modified, content) VALUES ('Test', '2017-06-05', '2018-02-02', '')";

        int result = jdbcTemplate.update(sql);

        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
    @RequestMapping("/notes")
    void postNote()
    {
        insertNote();
    }




}




