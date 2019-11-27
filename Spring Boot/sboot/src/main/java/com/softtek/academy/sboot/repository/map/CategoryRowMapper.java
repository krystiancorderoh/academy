package com.softtek.academy.sboot.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.sboot.domain.model.CategoryEntity;

@Component
@Scope("prototype")
public class CategoryRowMapper implements RowMapper<CategoryEntity> {

    @Override
    public CategoryEntity mapRow(final ResultSet rs, int rowNum) throws SQLException {

        CategoryEntity category = new CategoryEntity();
        category.setId(rs.getLong("id"));
        category.setDescription(rs.getString("description"));

        return category;
    }

}
