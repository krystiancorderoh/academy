package com.softtek.academy.sboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.sboot.domain.model.CategoryEntity;
import com.softtek.academy.sboot.repository.CategoryRepository;
import com.softtek.academy.sboot.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }
}
