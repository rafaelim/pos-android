package com.univem.aula.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener{

    private EditText loginField;
    private EditText passwordField;
    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginField = findViewById(R.id.loginField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.loginButton) {
            String login = loginField.getText().toString();
            String password = passwordField.getText().toString();
            if(isNotEmpty(login, password) && userExists(login, password)) {
//                Toast.makeText(this, login.concat(" - ").concat(password), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                User user = new User(login, password);
                intent.putExtra("user", user);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "User and password cannot be empty!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isNotEmpty(String login, String password) {
        return !TextUtils.isEmpty(login) && !TextUtils.isEmpty(password);
    }

    private boolean userExists(String login, String password) {
        return login.equals("admin") && password.equals("123");
    }
}
