package br.ufrn.imd.controller;

import br.ufrn.imd.model.User;

import java.util.Map;

public class UserController {
    private Map<String, User> users;

    public void registerUser(User user) {
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}