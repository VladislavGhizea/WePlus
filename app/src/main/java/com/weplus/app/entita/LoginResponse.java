package com.weplus.app.entita;

public class LoginResponse {

    private boolean success;
    private String password;

    public LoginResponse(boolean success, String password) {
        this.success = success;
        this.password=password;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getPassword() {
        return password;
    }
}
