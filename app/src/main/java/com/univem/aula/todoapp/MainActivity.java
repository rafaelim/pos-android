package com.univem.aula.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = getIntent().getExtras().getParcelable("user");
        Toast.makeText(this, user.getLogin().concat(" - ").concat(user.getPassword()), Toast.LENGTH_SHORT).show();

    }
}
