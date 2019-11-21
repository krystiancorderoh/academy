package com.softtek.academy.jpa.web;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.softtek.academy.jpa.domain.dto.ItemFilter;
import com.softtek.academy.jpa.domain.model.ItemEntity;
import com.softtek.academy.jpa.service.ItemService;
import com.softtek.academy.jpa.util.serializer.DataViews;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;
    
	@GetMapping(path = "/items")
	public List<ItemEntity> getItemsByCategory(@RequestParam("categoryId") Long categoryId) {
		LOGGER.info("Getting items for categoryId: {}", categoryId);

		return itemService.getByCategogyId(categoryId);
	}

//    @GetMapping(path = "/categories/{categoryId}/items")
//    @JsonView(DataViews.Basic.class)
//    public List<ItemEntity> getItemsByCategory(@PathVariable Long categoryId) {
//        LOGGER.info("Getting items for categoryId: {}", categoryId);
//
//        return itemService.getByCategogyId(categoryId);
//    }
//
//
//    @GetMapping(path = "/categories/{categoryId}/items/{itemId}")
//    @JsonView(DataViews.Full.class)
//    public ItemEntity getItemDetail(@PathVariable Long itemId) {
//        LOGGER.info("Getting item detail for itemId: {}", itemId);
//
//        return itemService.getItem(itemId);
//    }
//
//    @GetMapping(path = "/items")
//    @JsonView(DataViews.Basic.class)
//    public List<ItemEntity> searchItems(@ModelAttribute ItemFilter itemFilter) {
//        LOGGER.info("Fitering items by: {}", itemFilter);
//
//        return itemService.searchItems(itemFilter);
//    }
    
    @GetMapping(path = "/items/topTenWeek")
    public List<ItemEntity> getTopTenWeek(){
    	return itemService.getTopTenWeek();
    }

}
