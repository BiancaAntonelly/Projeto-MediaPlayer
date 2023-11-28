package br.ufrn.imd.controller;

import br.ufrn.imd.model.Usuario;

import java.util.Map;

public class UserController {
    private Map<String, Usuario> users;

    public void registerUser(Usuario user) {
    }

    public boolean authenticateUser(String username, String password) {
        Usuario user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}