package com.softtek.academy.ws.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

	private String description;

	private String features;

	private String uomId;

	private Double unitPrice;

	private String imagePath;

	private Integer stock;

	private Boolean active;

}
