package com.univem.aula.todoapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.univem.aula.todoapp.R;
import com.univem.aula.todoapp.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = getIntent().getExtras().getParcelable("user");
        Toast.makeText(this, user.getLogin().concat(" - ").concat(user.getPassword()), Toast.LENGTH_SHORT).show();

    }
}
