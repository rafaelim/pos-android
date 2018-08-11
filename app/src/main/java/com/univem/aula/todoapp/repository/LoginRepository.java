package com.univem.aula.todoapp.repository;

import com.univem.aula.todoapp.model.User;

public class LoginRepository {

    private static final String LOGIN_FAKE = "admin";
    private static final String PASSWORD_FAKE = "123";

    public boolean isUserExists(User user) {
        return user.getLogin().equalsIgnoreCase(LOGIN_FAKE) &&
                user.getPassword().equalsIgnoreCase(PASSWORD_FAKE);
    }
}
