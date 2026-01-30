package com.ik.spike.notesDb.service;

import com.ik.spike.notesDb.entity.User;

public interface UserService {
    User getUserByUsername(String username);
}
