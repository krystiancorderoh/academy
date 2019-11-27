package com.softtek.academy.jpa.domain.model;

import lombok.Data;

@Data
public class CartLineEntity {

    private Long id;

    private Long cartId;

    private ItemEntity item;

    private Long quantity;

}
