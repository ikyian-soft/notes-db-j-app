package com.ik.spike.notesDb.service;

import com.ik.spike.notesDb.entity.Note;
import com.ik.spike.notesDb.entity.User;

import java.util.List;

public interface NoteService {
    Note findById(String username, Long id);
    List<Note> findAll(User user);
    Note save(Note note);
    void delete(Note note);
}
