package com.softtek.academy.ws.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.softtek.academy.ws.domain.model.Category;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.domain.model.State;
import com.softtek.academy.ws.domain.model.Uom;
@Component
@Scope("prototype")
public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(final ResultSet rs,int rowNum) throws SQLException {
    	Item item = new Item();
		
		item.setId(rs.getLong("item_id"));
		item.setDescription(rs.getString("item_description"));
		item.setFeatures(rs.getString("item_features"));
		item.setUnitPrice(rs.getLong("item_unit_price"));
		
		item.setImagePath(rs.getString("item_image_path"));
		item.setStock(rs.getLong("item_stock"));
		item.setActive("Y".equals(rs.getString("item_active")));
		
	
		return item;
    }


}
