package com.example.nounours.Data;

public class User {

    private String username;
    private String password;
    private String request_token;

    public User(String _username, String _password, String _token) {
        username = _username;
        password = _password;
        request_token = _token;
    }

    public String get_username() {
        return username;
    }

    public String get_password() {
        return password;
    }

    public String get_token() {
        return request_token;
    }

    public void set_username(String _username) {
        this.username = _username;
    }

    public void set_password(String _password) {
        this.password = _password;
    }

    public void set_token(String _token) {
        this.request_token = _token;
    }
}
