package com.softtek.academy.jpa.domain.dto;

public class CityDto {

    private Long id;

    private String description;

    private Long stateId;
    
    private String stateName;

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

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }


    @Override
    public String toString() {
        return String.format("CityDto [id=%s, description=%s, stateId=%s]", id, description, stateId);
    }

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
