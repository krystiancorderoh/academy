package com.softtek.academy.ws.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Item {
	
	private Long id;
	
	private String description;
	
	private String features;
	
	private Uom uom;
	
	private Long unitPrice;
	
	private String imagePath;
	
	private Long stock;
	
	private boolean active;
	
	private List<Category> categories;

}
