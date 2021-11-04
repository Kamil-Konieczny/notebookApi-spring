package com.notes.demo.services;

import com.notes.demo.Note;
import com.notes.demo.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotesService {

@Autowired
NotesRepository notesRepository;

    public Note addNote(Note note)
    {
        return notesRepository.save(note);
    }
    public void deleteNote(Note note)
    {
         notesRepository.deleteById(note.getNote_id());
    }
    public Optional<Note> getNoteById(Long noteId)
    {
        return notesRepository.findById(noteId);
    }
}
