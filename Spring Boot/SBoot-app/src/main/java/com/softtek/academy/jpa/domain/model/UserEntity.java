package com.softtek.academy.jpa.domain.model;

import lombok.Data;

@Data
public class UserEntity {

    private String username;

    private String password;

    private String name;

    private UserRoleEntity userRole;

    private boolean active;

}
