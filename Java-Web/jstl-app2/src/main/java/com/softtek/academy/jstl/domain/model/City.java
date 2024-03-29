package com.softtek.academy.jstl.domain.model;

public class City {

    private Long id;

    private String description;

    private State state;


    public City() {
    }

    public City(Long id, String description, State state) {
        this.id = id;
        this.description = description;
        this.state = state;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return String.format("City [id=%s, description=%s, state=%s]", id, description, state);
    }

}
