package com.softtek.academy.servlet.domain.model;

public class CityEntity {

    private Long id;

    private String description;

    private StateEntity state;


    public CityEntity(Long id, String description, StateEntity state) {
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

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return String.format("City [id=%s, description=%s, state=%s]", id, description, state);
    }

}
