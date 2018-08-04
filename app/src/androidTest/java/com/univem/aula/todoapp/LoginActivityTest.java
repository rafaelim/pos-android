package com.univem.aula.todoapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class, true, false);
    
}