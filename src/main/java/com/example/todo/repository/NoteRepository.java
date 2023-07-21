package com.example.todo.repository;

import com.example.todo.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findAllByStatus(String status);

    @Query("select ne from NoteEntity ne " +
            "where ne.status = ?1 ")
    List<NoteEntity> getAllByStatus(String status);
}
