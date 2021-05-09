package com.devorator.calvus.notes.database;

public interface DatabaseController {
    void insert(String json);
    void update(String json, int noteId);
}
