package com.ik.spike.notesDb.controller;

import com.ik.spike.notesDb.service.NotFoundEception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotesControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<?> handleException(NotFoundEception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
