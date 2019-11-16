package com.softtek.academy.ws.web;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.softtek.academy.ws.domain.dto.ItemFilter;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.service.ItemService;

@RestController
@RequestMapping(value = "/items", 
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
//	
//	@GetMapping
//	public List<Item> getItems() throws SQLException{
//		return ItemService.getItems();
//	}
	
	@GetMapping("/{id}")
	public Item getItem(@PathVariable Long id) throws SQLException {
		
		return itemService.getItem(id);
	}
	
//	@GetMapping(params = {"categoryId"})
//	public List<Item> getByCategoryId(@RequestParam Long categoryId) throws SQLException{
//		return itemService.getItemByCategoryId(categoryId);
//	}
	
	
	
	@GetMapping
	public List<Item> searchItems(@ModelAttribute ItemFilter itemFilter){
		return itemService.getItemsByItemFilter(itemFilter);
	}
	
	@PostMapping(value = "/{id}/uploadImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void uploadImage(@PathVariable Long id, @RequestParam("itemImage") MultipartFile file) throws SQLException {
		itemService.uploadFile(id, file);
		
	}
//	@PostMapping
//	@ResponseStatus(code= HttpStatus.CREATED)
//	public Item saveItem(@RequestBody ItemDto itemDto) throws SQLException {
//		
//		return ItemService.save(itemDto);
//		
//	}
//	
//	@PutMapping(value="/{id}")
//	public Item updateState(@PathVariable Long id,@RequestBody ItemDto itemDto) throws SQLException {
//		return ItemService.update(id, itemDto);
//	}
//	
//	@DeleteMapping("/{id}")
//	@ResponseStatus(code= HttpStatus.NO_CONTENT)
//	public void delete(@PathVariable Long id) throws SQLException {
//		ItemService.delete(id);
//	}

}
