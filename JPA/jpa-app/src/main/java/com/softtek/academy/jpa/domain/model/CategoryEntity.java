package com.softtek.academy.jpa.domain.model;

public class CategoryEntity {

    private Long id;

    private String description;


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
