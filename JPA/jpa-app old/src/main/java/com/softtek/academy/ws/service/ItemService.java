package com.softtek.academy.ws.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.softtek.academy.ws.dao.ItemDao;
import com.softtek.academy.ws.domain.dto.ItemFilter;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	
	@Value("${item.file.path}")
	private String itemFilePath;

	public List<Item> getItems(ItemFilter itemFilter) throws SQLException {
		return itemDao.findByFilter(itemFilter);
	}

	public Item getItem(Long id) throws SQLException {
		return itemDao.findOne(id);
	}
	
	public List<Item> findByCategory(Long categoryId) {
		return itemDao.findByCategory(categoryId);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Item uploadFile(Long itemId, MultipartFile file) throws SQLException {
		Item item = null;
		try {
			log.info("Buscando item: " + itemId);
			itemDao.findOne(itemId);
		} catch (UncategorizedSQLException e) {
			log.info("No se encontró item");
			throw new NotFoundException("Not item found: " + itemId);
		}
		try {
			String serverPath = itemFilePath + file.getOriginalFilename();
			File uploadFile = new File(serverPath);
			file.transferTo(uploadFile);
			item = itemDao.updateImagePath(itemId, serverPath);
			log.info("File saved at: " +serverPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

}
