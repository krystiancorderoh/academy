package com.softtek.academy.jpa.domain.dto;

import lombok.Data;

@Data
public class ItemFilter {

    private String description;

    private String uomId;

    private NumericRange<Double> unitPrice;

    private boolean outOfStock;

    private Long categoryId;

}
