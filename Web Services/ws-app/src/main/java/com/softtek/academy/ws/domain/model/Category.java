package com.softtek.academy.ws.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
	private Long id;
	
	private String description;
}
