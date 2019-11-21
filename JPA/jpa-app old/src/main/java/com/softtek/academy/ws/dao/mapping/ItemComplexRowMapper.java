package com.softtek.academy.ws.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.softtek.academy.ws.domain.model.Category;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.domain.model.UOM;

@Component
public class ItemComplexRowMapper implements ResultSetExtractor<Item> {

	@Override
	public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
		rs.next();

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
		item.setActive("Y".equals(rs.getString("active")));

		List<Category> categories = new ArrayList<Category>();
		do {
			if(rs.getString("category_description") != null) {
				categories.add(new Category(rs.getLong("category_id"), rs.getString("category_description")));
			}
		} while (rs.next());
		item.setCategory(categories);
		return item;
	}

}
