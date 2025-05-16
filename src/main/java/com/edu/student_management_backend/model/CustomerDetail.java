package com.edu.student_management_backend.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerDetail implements UserDetails{
    private String username;
    private String password;
    private String hovaten;
    private Collection<? extends GrantedAuthority> authorities;

    
    public CustomerDetail(String username, String password, String hovaten,
    Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.hovaten = hovaten;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getHovaten() {
        return hovaten;
    }
    
}
