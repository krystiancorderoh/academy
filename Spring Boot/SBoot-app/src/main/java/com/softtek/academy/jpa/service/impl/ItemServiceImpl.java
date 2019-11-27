package com.softtek.academy.jpa.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.softtek.academy.jpa.domain.dto.ItemFilter;
import com.softtek.academy.jpa.domain.model.ItemEntity;
import com.softtek.academy.jpa.exception.IncompleteOperationException;
import com.softtek.academy.jpa.exception.NotFoundException;
import com.softtek.academy.jpa.repository.ItemRepository;
import com.softtek.academy.jpa.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Value("${item.file.path}")
    private String itemFilePath;


    @Override
    public ItemEntity getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new NotFoundException("No data found for ite: " + id));
    }

    @Override
    public List<ItemEntity> getByCategogyId(Long categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<ItemEntity> searchItems(ItemFilter itemFilter) {
        return itemRepository.getByFilter(itemFilter);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadFile(Long id, MultipartFile file) {
        String serverPath = itemFilePath + file.getOriginalFilename();

        ItemEntity item = getItem(id);
        item.setImagePath(serverPath);
        itemRepository.save(item);

        try {
            File uploadFile = new File(serverPath);
            file.transferTo(uploadFile);
        } catch (final Exception ex) {
            throw new IncompleteOperationException("Upload file failed for item: " + id);
        }
    }

}
