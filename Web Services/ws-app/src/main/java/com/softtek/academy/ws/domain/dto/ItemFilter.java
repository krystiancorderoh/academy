package com.softtek.academy.ws.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemFilter {

    private String description;

    private String uomId;

    private Boolean outOfStock; // true if (stock = 0)

    private Long categoryId;

}
