package com.softtek.academy.ws.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.softtek.academy.ws.dao.ItemDao;
import com.softtek.academy.ws.domain.dto.ItemFilter;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.exception.InvalidInputException;
import com.softtek.academy.ws.exception.NotFoundException;
@Service
public class ItemService {
	@Autowired
    private ItemDao itemDao;
	
	@Value("${item.file.path}")
	private String path;


    public Item getItem(Long id) throws SQLException {
        return itemDao.findOne(id);
    }
    
    public List<Item> getItemByCategoryId(Long id) throws SQLException {
        return itemDao.findByCategoryId(id);
    }
    
    public List<Item> getItemsByItemFilter (ItemFilter itemFilter){
    	return itemDao.findByItemFilter(itemFilter);
    }
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public void uploadFile(Long id, MultipartFile file) throws SQLException {
    	
    	
    	
    	
    	String serverPath = path + file.getOriginalFilename();
    	try {
    		itemDao.findOne(id);
    		
    	}catch(final Exception ex){
    		throw new NotFoundException("invalid for itemId: " + id);
    	}
    	
    	itemDao.updateImagePath(id,serverPath);
    	
    	try {
			
			File uploadFile = new File(serverPath);
			file.transferTo(uploadFile);
		}catch (final Exception ex) {
			ex.printStackTrace();
		}
    }

//    public List<Item> getItems() throws SQLException {
//        return itemDao.findAll();
//    }
//
//    public Item save(ItemDto ItemDto) throws SQLException {
//        validate(ItemDto);
//
//        return itemDao.save(ItemDto);
//    }
//
//    private void validate(ItemDto ItemDto) throws InvalidInputException {
//        if (StringUtils.isBlank(ItemDto.getDescription()) || ItemDto.getStateId() == null) {
//            throw new InvalidInputException("Valid id, description and stateId requiered");
//        }
//
//    }
//
//    public Item update(Long ItemId, ItemDto ItemDto) throws InvalidInputException, SQLException {
//        validate(ItemDto);
//
//        return itemDao.update(ItemId, ItemDto);
//    }
//
//    public void delete(Long ItemId) throws SQLException {
//        itemDao.delete(ItemId);
//    }
}
