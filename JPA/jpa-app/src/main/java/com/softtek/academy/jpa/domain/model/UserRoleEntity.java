package com.softtek.academy.jpa.domain.model;

public class UserRoleEntity {

    private String id;

    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return String.format("UserRoleEntity [id=%s, description=%s]", id, description);
    }

}
