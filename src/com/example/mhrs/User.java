package com.example.mhrs;

public class User {
    private final String id;
    private final String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
