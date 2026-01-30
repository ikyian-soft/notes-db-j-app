package com.ik.spike.notesDb.service;

import com.ik.spike.notesDb.entity.Note;
import com.ik.spike.notesDb.entity.User;
import com.ik.spike.notesDb.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note findById(String username, Long id) {
        return getNoteByIdForUser(username, id);
    }

    @Override
    public List<Note> findAll(User user) {
        return noteRepository.findAllByUser(user);
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void delete(Note note) {
        noteRepository.delete(note);
    }

    private Note getNoteByIdForUser(String username, Long id) {
        Optional<Note> optNote = noteRepository.findById(id);
        if (optNote.isPresent()) {
            Note foundNote = optNote.get();
            if (!foundNote.getUser().getUsername().equals(username)) {
                throw new NotFoundEception("User Note is not found: " + id);
            }
            return foundNote;
        }
        throw new NotFoundEception("Note is not found: " + id);
    }

}
