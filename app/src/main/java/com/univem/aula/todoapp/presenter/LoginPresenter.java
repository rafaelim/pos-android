package com.univem.aula.todoapp.presenter;

import com.univem.aula.todoapp.model.User;
import com.univem.aula.todoapp.repository.LoginRepository;

public class LoginPresenter {

    private LoginRepository repository;
    public LoginPresenter(LoginRepository repository) {
        this.repository = repository;
    }

    public void login(User user) {
        if (repository.isUserExists(user)) {
            // TODO notificar view success
        } else {
            // TODO notificar view error
        }
    }
}
