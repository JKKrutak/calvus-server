package com.devorator.calvus.notes.database;

import com.devorator.calvus.notes.Note;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class NotesDatabaseController implements DatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(String json) {

       // json = "{\"name\":\"Thinking in Java\",\"content\":\"I was facing a similar problem today.\"}";
        LocalDate todayDate = LocalDate.now();
        try {
            ObjectMapper mapper = new ObjectMapper();
            Note note = mapper.readValue(json, Note.class);
            String sql = "INSERT INTO notes (note_NAME, creation_DATE, modified, content) VALUES ('"+note.getName()+"', '"+todayDate+"', '"+todayDate+"', '"+note.getContent()+"')";
            int result = jdbcTemplate.update(sql);
            if (result > 0) {
                System.out.println("A new row has been inserted.");
            } else {
                System.out.println("A new row has NOT been inserted.");
            }
        }catch(Exception e) {
            System.out.print(e);
        }
    }

    @Override
    public void update(String json, int noteId)
    {
        LocalDate todayDate = LocalDate.now();
        try {
            ObjectMapper mapper = new ObjectMapper();
            Note note = mapper.readValue(json, Note.class);
            String sql = "UPDATE notes SET modified = '"+todayDate+"', content = '"+note.getContent()+"' WHERE note_ID = "+noteId+";";
            int result = jdbcTemplate.update(sql);
            if (result > 0) {
                System.out.println("Note with id: "+noteId+" has been edited.");
            } else {
                System.out.println("Note with id: "+noteId+" has NOT been edited.");
            }
        }catch(Exception e) {
            System.out.print(e);
        }

    }
}
