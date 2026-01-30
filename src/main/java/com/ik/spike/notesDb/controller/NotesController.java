package com.ik.spike.notesDb.controller;

import com.ik.spike.notesDb.entity.Note;
import com.ik.spike.notesDb.entity.User;
import com.ik.spike.notesDb.service.NoteService;
import com.ik.spike.notesDb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Controller
public class NotesController {

    private final NoteService noteService;
    private final UserService userService;

    public NotesController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("")
    public String home(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        List<Note> notes = noteService.findAll(user);
        model.addAttribute("notes", notes);
        model.addAttribute("username", principal.getName());
        return "home";
    }

    @GetMapping("create")
    public String createNote(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        model.addAttribute("mode", "create");
        return "note";
    }

    @PostMapping("create")
    public String doCreateNote(NoteData data, Principal principal) {
        Note note = new Note();
        note.setTitle(data.getTitle());
        note.setContent(data.getContent());
        User user = userService.getUserByUsername(principal.getName());
        note.setUser(user);
        noteService.save(note);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editNote(@PathVariable Long id, Model model, Principal principal) {
        Note note = noteService.findById(principal.getName(), id);
        model.addAttribute("note", note);
        model.addAttribute("mode", "edit");
        return "note";
    }

    @PostMapping("edit/{id}")
    public String doEditNote(@PathVariable Long id, NoteData data, Principal principal) {
        Note note = noteService.findById(principal.getName(), id);
        note.setTitle(data.getTitle());
        note.setContent(data.getContent());
        noteService.save(note);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteNote(@PathVariable Long id, Model model, Principal principal) {
        Note note = noteService.findById(principal.getName(), id);
        model.addAttribute("note", note);
        model.addAttribute("mode", "delete");
        return "note";
    }

    @PostMapping("delete/{id}")
    public String doDeleteNote(@PathVariable Long id, Principal principal) {
        Note note = noteService.findById(principal.getName(), id);
        noteService.delete(note);
        return "redirect:/";
    }

    @GetMapping("access-denied")
    public String access_denied(){
        return "access-denied";
    }

}
