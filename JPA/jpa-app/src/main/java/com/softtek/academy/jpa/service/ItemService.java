package com.softtek.academy.jpa.service;

import java.util.List;

import com.softtek.academy.jpa.domain.dto.ItemFilter;
import com.softtek.academy.jpa.domain.model.ItemEntity;

public interface ItemService {

//    ItemEntity getItem(final Long itemId);
//
    List<ItemEntity> getByCategogyId(final Long categoryId);
//
//    List<ItemEntity> searchItems(final ItemFilter itemFilter);
    
    List<ItemEntity> getTopTenWeek();

}
