package com.softtek.academy.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.softtek.academy.jpa.domain.dto.ItemFilter;
import com.softtek.academy.jpa.domain.model.ItemEntity;
import com.softtek.academy.jpa.service.ItemService;
import com.softtek.academy.jpa.util.serializer.DataViews;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping("/{id}")
    @JsonView(DataViews.Full.class)
    public ItemEntity getItemDetail(@PathVariable Long id) {
        log.info("Getting item detail for item: {}", id);

        return itemService.getItem(id);
    }


    @GetMapping(params = {"categoryId"})
    @JsonView(DataViews.Basic.class)
    public List<ItemEntity> getItemsByCategory(@PathVariable Long categoryId) {
        log.info("Getting items for categoryId: {}", categoryId);

        return itemService.getByCategogyId(categoryId);
    }

    @GetMapping
    @JsonView(DataViews.Basic.class)
    public List<ItemEntity> searchItems(@ModelAttribute ItemFilter itemFilter) {
        log.info("Fitering items by: {}", itemFilter);

        return itemService.searchItems(itemFilter);
    }

    @PostMapping(value = "/{id}/uploadimage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@PathVariable Long id, @RequestParam("itemImage") MultipartFile file) {
        itemService.uploadFile(id, file);
    }

}
