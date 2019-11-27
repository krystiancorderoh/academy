package com.softtek.academy.sboot.domain.model;

import lombok.Data;

@Data
public class CartLineEntity {

    private Long id;

    private Long cartId;

    private ItemEntity item;

    private Long quantity;

}
