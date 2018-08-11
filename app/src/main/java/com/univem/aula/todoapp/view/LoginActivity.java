package com.univem.aula.todoapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.univem.aula.todoapp.R;
import com.univem.aula.todoapp.model.User;
import com.univem.aula.todoapp.presenter.LoginPresenter;
import com.univem.aula.todoapp.repository.LoginRepository;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener, LoginView {

    private EditText loginField;
    private EditText passwordField;
    private Button loginButton;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginField = findViewById(R.id.loginField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);

        presenter = new LoginPresenter(new LoginRepository(), this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.loginButton) {
            String login = loginField.getText().toString();
            String password = passwordField.getText().toString();
            presenter.login(new User(login, password));
        }
    }

    @Override
    public void onLoginSuccess(User user) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginError() {
        Toast.makeText(this, "Error. Try again later!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserNotFilledCorrectly() {
        Toast.makeText(this, "User not filled correctly", Toast.LENGTH_SHORT).show();
    }
}
