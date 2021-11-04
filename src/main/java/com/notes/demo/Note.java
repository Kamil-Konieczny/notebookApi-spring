package com.notes.demo;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Note {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long note_id;
    Date noteDate;
    @Lob @Basic(fetch=LAZY)
    String content;
    String title;
    @ManyToOne
    User user;

    public Note() {
    }

    public Note(Date noteDate, String content, String title) {
        this.noteDate = noteDate;
        this.content = content;
        this.title = title;
    }

    @PrePersist
    void createdAt() {
        this.noteDate = new Date(System.currentTimeMillis());
    }
    public Long getNote_id() {
        return note_id;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
