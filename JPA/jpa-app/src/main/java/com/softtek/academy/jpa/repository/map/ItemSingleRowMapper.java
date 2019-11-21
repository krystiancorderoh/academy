package com.softtek.academy.jpa.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.model.ItemEntity;

@Component
@Scope("prototype")
public class ItemSingleRowMapper implements RowMapper<ItemEntity> {

    @Override
    public ItemEntity mapRow(final ResultSet rs, int rowNum) throws SQLException {

        final ItemEntity item = new ItemEntity();
        item.setId(rs.getLong("id"));
        item.setDescription(rs.getString("description"));
        item.setFeatures(rs.getString("features"));
        item.setUnitPrice(rs.getDouble("unit_price"));
        item.setImagePath(rs.getString("image_path"));
        item.setStock(rs.getLong("stock"));
        item.setActive(rs.getString("active"));

        return item;
    }

}
