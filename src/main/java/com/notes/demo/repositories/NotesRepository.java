package com.notes.demo.repositories;

import com.notes.demo.Note;
import com.notes.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Note,Long> {
    @Query("SELECT u FROM Note u WHERE u.title=?1")
    Optional<Note> findNoteByTitle(String title);
}
