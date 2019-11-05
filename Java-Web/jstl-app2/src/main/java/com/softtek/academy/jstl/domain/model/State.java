package com.softtek.academy.jstl.domain.model;

public class State {

    private Long id;

    private String description;


    public State(Long id) {
        this.id = id;
    }

    public State(String description) {
        this.description = description;
    }

    public State(Long id, String description) {
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
