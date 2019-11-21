package com.softtek.academy.ws.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class Item {

	private Long id;
	
	private String description;
	
	private String features;
	
	private UOM uom;
	
	private Double unitPrice;
	
	private String imagePath;
	
	private Integer stock;
	
	private Boolean active;
	
	private List<Category> category;

}
