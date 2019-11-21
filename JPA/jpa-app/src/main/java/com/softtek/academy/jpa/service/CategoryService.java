package com.softtek.academy.jpa.service;

import java.util.List;

import com.softtek.academy.jpa.domain.model.CategoryEntity;

public interface CategoryService {

    List<CategoryEntity> getCategories();

}
