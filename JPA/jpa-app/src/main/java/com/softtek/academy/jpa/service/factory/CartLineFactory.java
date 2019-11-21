package com.softtek.academy.jpa.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.dto.CartLineDto;
import com.softtek.academy.jpa.domain.model.CartLineEntity;
import com.softtek.academy.jpa.repository.ItemRepository;

@Component
public class CartLineFactory implements EntityFactory<CartLineDto, CartLineEntity> {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public CartLineEntity createEntity(CartLineDto dto) {

        CartLineEntity line = new CartLineEntity();
//        line.setItem(itemRepository.findOne(dto.getItemId()));
        line.setQuantity(dto.getQuantity());

        return line;
    }

}
