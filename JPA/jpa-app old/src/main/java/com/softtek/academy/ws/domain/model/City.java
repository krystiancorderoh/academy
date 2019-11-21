package com.softtek.academy.ws.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="CITY")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="state_id", referencedColumnName = "id")
	private State state;
    
//	@Column(name = "state_id")
//	private Integer stateId;
////	
	
}
