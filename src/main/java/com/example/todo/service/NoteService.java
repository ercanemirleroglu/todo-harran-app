package com.example.todo.service;

import com.example.todo.dto.NoteDto;
import com.example.todo.entity.NoteEntity;
import com.example.todo.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDto> getAllNotes() {
        return noteRepository.findAll().stream().map(NoteEntity::toDto).collect(Collectors.toList());
    }

    public void createNote(NoteDto note) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setContent(note.getContent());
        noteEntity.setCreatedDate(LocalDateTime.now());
        noteEntity.setStatus("NEW");
        noteRepository.save(noteEntity);
    }

    public NoteDto getNoteById(Long noteId) {
        return noteRepository.findById(noteId).map(NoteEntity::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Note not found!"));
    }

    public void updateNote(Long noteId, NoteDto note) {
        NoteEntity noteById = noteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note not found!"));
        noteById.setContent(note.getContent());
        noteById.setStatus(note.getStatus());
        noteRepository.save(noteById);
    }

    public void completeNote(Long noteId) {
        NoteEntity noteById = noteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note not found!"));
        noteById.setStatus("DONE");
        noteRepository.save(noteById);
    }

    public void deleteNote(Long noteId) {
        NoteEntity noteById = noteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note not found!"));
        noteRepository.delete(noteById);
    }
}
