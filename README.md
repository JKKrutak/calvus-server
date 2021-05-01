#Calvus devorator
Simple notes synchronizer.
#### Table-making query
```mysql
create table notes(
    note_ID INT NOT NULL AUTO_INCREMENT,
    note_NAME varchar(100) NOT NULL,
    creation_DATE DATE, modified DATE,
    content TEXT,
    PRIMARY KEY (note_ID)
);
```
---
#TODO LIST:

- [ ] Implementation NotesDatabaseController.
- [ ] Json handling.
- [ ] Everything rest.


