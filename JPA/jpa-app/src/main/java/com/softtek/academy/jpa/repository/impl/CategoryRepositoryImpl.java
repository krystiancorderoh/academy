package com.softtek.academy.jpa.repository.impl;

import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.jpa.domain.model.CategoryEntity;
import com.softtek.academy.jpa.repository.CategoryRepository;
import com.softtek.academy.jpa.repository.map.CategoryRowMapper;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectFactory<CategoryRowMapper> rowMapperFactory;


    @Override
    public List<CategoryEntity> findAll() {

        return jdbcTemplate.query("SELECT * FROM category", rowMapperFactory.getObject());
    }
}