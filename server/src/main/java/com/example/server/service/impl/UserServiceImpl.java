package com.example.server.service.impl;

import com.example.server.dao.UserDAO;
import com.example.server.entity.User;
import com.example.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public boolean isExist(String username) {
        User user = getByName(username);
        return user != null;
    }

    @Override
    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public User get(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    @Override
    public void add(User user) {
        userDAO.save(user);
    }

}
