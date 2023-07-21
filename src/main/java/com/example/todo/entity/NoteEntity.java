package com.example.todo.entity;

import com.example.todo.dto.NoteDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "note")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    public NoteDto toDto() {
        NoteDto noteDto = new NoteDto();
        noteDto.setContent(this.content);
        noteDto.setCreatedDate(this.createdDate);
        noteDto.setId(this.id);
        noteDto.setStatus(this.status);
        return noteDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
