package com.univem.aula.todoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private User(Parcel p){
        login = p.readString();
        password = p.readString();
    }

    public static final Parcelable.Creator<User>
            CREATOR = new Parcelable.Creator<User>() {

        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(password);
    }
}
