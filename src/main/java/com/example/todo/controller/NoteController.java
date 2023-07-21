package com.example.todo.controller;

import com.example.todo.dto.NoteDto;
import com.example.todo.entity.NoteEntity;
import com.example.todo.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> getAll() {
        List<NoteDto> allNotes = noteService.getAllNotes();
        return ResponseEntity.ok().body(allNotes);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long noteId) {
        NoteDto noteDto = noteService.getNoteById(noteId);
        return ResponseEntity.ok().body(noteDto);
    }

    @PostMapping
    public ResponseEntity<Void> createNote(@RequestBody NoteDto note) {
        noteService.createNote(note);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<Void> updateNote(@PathVariable Long noteId,
                                           @RequestBody NoteDto note) {
        noteService.updateNote(noteId, note);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{noteId}/done")
    public ResponseEntity<Void> completeNote(@PathVariable Long noteId) {
        noteService.completeNote(noteId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long noteId) {
        noteService.deleteNote(noteId);
        return ResponseEntity.ok().build();
    }

}
