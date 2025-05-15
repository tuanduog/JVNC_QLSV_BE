package com.edu.student_management_backend.model;

public class AuthResponse {
    private String token;
    private String role;

    public AuthResponse(String token, String role){
        this.token = token;
        this.role = role;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
