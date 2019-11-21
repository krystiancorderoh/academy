package com.softtek.academy.jpa.domain.model;

public class UserEntity {

    private String username;

    private String password;

    private String name;

    private UserRoleEntity userRole;

    private boolean active;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRoleEntity getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEntity userRole) {
        this.userRole = userRole;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return String.format("UserEntity [username=%s, password=%s, name=%s, userRole=%s, active=%s]",
                username, password, name, userRole, active);
    }

}
