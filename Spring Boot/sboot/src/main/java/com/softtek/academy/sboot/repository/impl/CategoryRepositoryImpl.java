package com.softtek.academy.sboot.repository.impl;

import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.sboot.domain.model.CategoryEntity;
import com.softtek.academy.sboot.repository.CategoryRepository;
import com.softtek.academy.sboot.repository.map.CategoryRowMapper;

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