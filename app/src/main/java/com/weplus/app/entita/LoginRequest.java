package com.weplus.app.entita;

public class LoginRequest {

    private String username;

    public LoginRequest(String username, String password) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
