package com.devorator.calvus.notes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotesController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/notes")
    String HelloWorld(){
        return "<h1>HelloWorld</h1>";
    }

    public void insertNote(){
        String sql = "INSERT INTO notes (note_ID, note_NAME, creation_DATE, modified, content) VALUES (1, 'Test', '2017-06-15', '2017-06-15', ' Lorem ipsum dolor sit amet, consectetur adipiscing elit. In malesuada libero non egestas lobortis. Maecenas aliquet enim eu auctor pulvinar. Vestibulum faucibus facilisis augue, quis finibus mi sagittis vel. Cras nisl tellus, laoreet placerat feugiat sed, malesuada commodo mi. Fusce vitae auctor elit, id congue massa. Cras ac placerat turpis. Morbi congue nulla at varius efficitur. Pellentesque ullamcorper leo eget vulputate laoreet.'";
        int result = jdbcTemplate.update(sql);

        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
    @GetMapping(value = "/notes")
    void postNote()
    {
        insertNote();
    }




}




