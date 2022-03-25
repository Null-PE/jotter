package com.example.server.service;

import com.example.server.entity.User;

public interface UserService {
    boolean isExist(String username);

    User getByName(String username);

    User get(String username, String password);

    void add(User user);
}
