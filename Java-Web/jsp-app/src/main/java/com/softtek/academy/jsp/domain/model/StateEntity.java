package com.softtek.academy.jsp.domain.model;

public class StateEntity {

    private Long id;

    private String description;


    public StateEntity(Long id) {
        this.id = id;
    }

    public StateEntity(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
