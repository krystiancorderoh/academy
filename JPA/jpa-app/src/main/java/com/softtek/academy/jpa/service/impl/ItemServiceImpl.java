package com.softtek.academy.jpa.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.jpa.domain.dto.ItemFilter;
import com.softtek.academy.jpa.domain.model.ItemEntity;
import com.softtek.academy.jpa.repository.ItemRepository;
import com.softtek.academy.jpa.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


//    @Override
//    public ItemEntity getItem(final Long itemId) {
////        return itemRepository.findOne(itemId);
//    	return null;
//    }

    @Override
    public List<ItemEntity> getByCategogyId(final Long categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }

//    @Override
//    public List<ItemEntity> searchItems(final ItemFilter itemFilter) {
//        return itemRepository.getByFilter(itemFilter);
//    }

	@Override
	public List<ItemEntity> getTopTenWeek() {
		LocalDateTime actualDay = LocalDateTime.now();
    	
		LocalDateTime aWeekAgo = actualDay.minusDays(7);
		
		return itemRepository.getTopTenWeek(aWeekAgo);
	}
}
