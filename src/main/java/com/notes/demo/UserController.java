package com.notes.demo;

import com.notes.demo.services.NotesService;
import com.notes.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    NotesService notesService;

    @PostMapping("/addnote")
    public Note addNote(@RequestParam(required=false,name="nickname") String nickname,
                        @RequestParam(required=false,name="title") String title,
                        @RequestParam(required=false,name="content") String content)
    {
        Note note = new Note(new Date(),content,title);
        Optional<User> userOptional = userService.getUserByUsername(nickname);
        User user = null;
        if(userOptional.isPresent())
        {
            user = userOptional.get();
        }
        user.getNotes().add(note);
        userService.update(user);
        return notesService.addNote(note);
    }



    @GetMapping("/user/{nickname}")
    public Optional<User> getUserByNickname(@PathVariable String nickname)
    {
       return userService.getUserByUsername(nickname);
    }

    @DeleteMapping("/deletenote")
    public void deleteNote(@RequestParam("nickname")String nickname,
                           @RequestParam("note_id")Long note_id)
    {
        Optional<User> userOptional = userService.getUserByUsername(nickname);
        User user = null;
        if(userOptional.isPresent())
        {
            user = userOptional.get();
        }
        Optional<Note> noteOptional = notesService.getNoteById(note_id);
        Note note = null;
        if(noteOptional.isPresent())
        {
            note = noteOptional.get();
        }
        user.getNotes().remove(note);
        userService.update(user);
        notesService.deleteNote(note);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user)
    {
    return userService.saveUser(user);
    }
}
