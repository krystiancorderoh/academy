package com.softtek.academy.jstl.domain.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Status {
	
	int idStatus;
	String name;
	String description;

}
