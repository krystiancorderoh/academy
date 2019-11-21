package com.softtek.academy.jpa.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.querydsl.binding.QuerydslPredicate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "STATE")
@NamedQueries({
	@NamedQuery(name="StateEntity.findByChiapas", query="select s from StateEntity s where s.id=6"),
	@NamedQuery(name="StateEntity.findByYucatan", query="select s from StateEntity s where s.id=7")
})
public class StateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="state", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private Collection<CityEntity> cities =new ArrayList<>();

    public StateEntity() {
    }

    public StateEntity(Long id) {
        this.id = id;
    }

    public StateEntity(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    
//    public StateEntity(Long id, String description, Collection<CityEntity> cities) {
//        this.id = id;
//        this.description = description;
//        this.cities=cities;
//    }

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

    public Collection<CityEntity> getCities() {
		return cities;
	}

	public void addCityEntity(CityEntity city) {
		this.cities.add(city);
		city.setState(this);
	}
	
	public void removeCityEntity(CityEntity city) {
		city.setState(null);
		this.cities.remove(city);
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StateEntity other = (StateEntity) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("State [id=%s, description=%s] ", id, description) ;
    }

}
