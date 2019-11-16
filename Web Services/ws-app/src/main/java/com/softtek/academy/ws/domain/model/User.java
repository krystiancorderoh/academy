package com.softtek.academy.ws.domain.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {

    private String username;

    private String password;

    private String name;

    private UserRole userRole;

    private boolean active;

    public User(String username) {
    	this.username= username;
    }

}
