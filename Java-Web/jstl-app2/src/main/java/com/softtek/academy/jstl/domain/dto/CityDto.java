package com.softtek.academy.jstl.domain.dto;

public class CityDto {

    private String description;

    private Long stateId;


    public CityDto(String description, Long stateId) {
        this.description = description;
        this.stateId = stateId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }


    @Override
    public String toString() {
        return String.format("CityDto [description=%s, stateId=%s]", description, stateId);
    }

}
