package com.softtek.academy.jpa.domain.model;

public class UomEntity {

    private String id;

    private String description;


    public UomEntity() {
    }

    public UomEntity(String id, String description) {
        this.id = id;
        this.description = description;
    }

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
        return String.format("State [id=%s, description=%s]", id, description);
    }

}
