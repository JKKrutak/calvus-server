package com.devorator.calvus.notes.database;

import com.devorator.calvus.notes.Note;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotesDatabaseController implements DatabaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert() {

        String json = "{\"name\":\"Thinking in Java\",\"content\":\"I was facing a similar problem today. It seems, it is not possible to deserialize a JSON-Array to a Java String[] or List when the property to serialize is the JSON root property.\"}";

        try {
            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);//No idea what that does, stackoverflow told me to paste it here.
            Note note = mapper.readValue(json, Note.class);
            String sql = "INSERT INTO notes (note_NAME, creation_DATE, modified, content) VALUES ('"+note.getName()+"', '2017-06-05', '2018-02-02', '"+note.getContent()+"')";
            int result = jdbcTemplate.update(sql);
            if (result > 0) {
                System.out.println("A new row has been inserted.");
            }
        }catch(Exception e) {
            System.out.print(e);
        }
    }
}
