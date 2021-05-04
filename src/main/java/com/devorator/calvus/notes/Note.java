package com.devorator.calvus.notes;

import java.time.LocalDate;


public class Note {
    private String name;
    //private LocalDate creation_date;
   // private LocalDate modified;
    private String content;

    public Note() {
       // creation_date = LocalDate.now();
       // modified = LocalDate.now();
    }

    public Note(String name, String content) {
     //   creation_date = LocalDate.now();
     //   modified = LocalDate.now();
        this.name = name;
        this.content = content;
    }

   // public LocalDate getModified() {
   //     return modified;
  //  }
    public String getContent() {
        return content;
    }
  //  public LocalDate getCreation_date() {
  //      return creation_date;
 //   }
    public String getName() {
        return name;
    }
}
