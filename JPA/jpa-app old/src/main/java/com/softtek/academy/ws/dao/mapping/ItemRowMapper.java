package com.softtek.academy.ws.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.domain.model.UOM;

@Component
public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		UOM uom = new UOM();
		uom.setDescription(rs.getString("uom_description"));
		uom.setId(rs.getString("uom_id"));
		
		Item item = new Item();
		item.setId(rs.getLong("id"));
		item.setDescription(rs.getString("description"));
		item.setFeatures(rs.getString("features"));
		item.setUom(uom);
		item.setUnitPrice(rs.getDouble("unit_price"));
		item.setImagePath(rs.getString("image_path"));
		item.setStock(rs.getInt("stock"));
		item.setActive(rs.getString("active").equals("Y"));
		
		return item;
	}

}
