package com.notes.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long user_id;
    String nickname;

    public User(String nickname, List<Note> notes) {
        this.nickname = nickname;
        this.notes = notes;
    }

    public User(String nickname) {
        this.nickname = nickname;
    }

    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="user_note",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="note_id", unique=true))
    private List<Note> notes = new ArrayList<>();
}
