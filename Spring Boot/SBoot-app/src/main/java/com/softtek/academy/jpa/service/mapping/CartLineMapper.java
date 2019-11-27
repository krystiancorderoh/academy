package com.softtek.academy.jpa.service.mapping;

import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CartLineDto;
import com.softtek.academy.jpa.domain.model.CartLineEntity;
import com.softtek.academy.jpa.domain.model.ItemEntity;

@Component
public class CartLineMapper implements EntityMapper<CartLineDto, CartLineEntity> {

    @Override
    public CartLineEntity mapEntity(CartLineDto dto) {

        CartLineEntity line = new CartLineEntity();
        line.setItem(new ItemEntity(dto.getItemId()));;
        line.setQuantity(dto.getQuantity());

        return line;
    }

}
