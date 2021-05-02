package com.devorator.calvus.notes.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotesDatabaseController implements DatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert() {
        String sql = "INSERT INTO notes (note_NAME, creation_DATE, modified, content) VALUES ('Test', '2017-06-05', '2018-02-02', '')";

        int result = jdbcTemplate.update(sql);

        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
}
