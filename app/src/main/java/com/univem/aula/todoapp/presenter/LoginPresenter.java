package com.univem.aula.todoapp.presenter;

import com.univem.aula.todoapp.model.User;
import com.univem.aula.todoapp.repository.LoginRepository;
import com.univem.aula.todoapp.view.LoginView;

public class LoginPresenter {

    private LoginRepository repository;
    private LoginView view;

    public LoginPresenter(LoginRepository repository, LoginView view) {
        this.repository = repository;
        this.view = view;
    }

    public void login(User user) {
        if (!fieldsFilled(user)) {
            view.onUserNotFilledCorrectly();
            return;
        }

        if (repository.isUserExists(user)) {
            view.onLoginSuccess(user);
        } else {
            view.onLoginError();
        }
    }

    private boolean fieldsFilled(User user) {
        return user.getLogin() != null && user.getLogin().length() > 0
                && user.getPassword() != null && user.getPassword().length() > 0;
    }
}
