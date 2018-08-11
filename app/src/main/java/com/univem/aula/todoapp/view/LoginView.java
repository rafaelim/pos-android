package com.univem.aula.todoapp.view;

import com.univem.aula.todoapp.model.User;

public interface LoginView {

    void onLoginSuccess(User user);

    void onLoginError();

    void onUserNotFilledCorrectly();
}
