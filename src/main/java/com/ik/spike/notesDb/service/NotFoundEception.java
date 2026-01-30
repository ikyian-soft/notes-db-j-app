package com.ik.spike.notesDb.service;

public class NotFoundEception extends RuntimeException {
    public NotFoundEception(String msg) {
        super(msg);
    }
}
