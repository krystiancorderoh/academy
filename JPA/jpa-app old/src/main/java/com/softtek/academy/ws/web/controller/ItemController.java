package com.softtek.academy.ws.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.softtek.academy.ws.domain.dto.ItemFilter;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping
	public List<Item> getItems(@ModelAttribute ItemFilter itemFilter) throws SQLException {
		log.info("El filtro es" + itemFilter.toString());
		return itemService.getItems(itemFilter);
	}

	@GetMapping("/{itemId}")
	public Item getItem(@PathVariable Long itemId) throws SQLException {
		return itemService.getItem(itemId);
	}

	@PostMapping(value = "/{itemId}/uploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Item uploadImage(@PathVariable Long itemId, @RequestParam("itemImage") MultipartFile file) throws SQLException {
		return itemService.uploadFile(itemId, file);
	}

	/*
	 * @GetMapping(params = {"categoryId"}) public List<Item>
	 * getByCategory(@RequestParam Long categoryId) throws SQLException { return
	 * itemService.findByCategory(categoryId); }
	 */

}
