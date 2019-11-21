package com.softtek.academy.jpa.domain.dto;

public class CartLineDto {

    private Long itemId;

    private Long quantity;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("CartLineDto [itemId=%s, quantity=%s]", itemId, quantity);
    }

}
