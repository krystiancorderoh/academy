package com.softtek.academy.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.jpa.domain.model.CategoryEntity;
import com.softtek.academy.jpa.repository.CategoryRepository;
import com.softtek.academy.jpa.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }
}
