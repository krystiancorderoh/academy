package com.softtek.academy.ws.dao.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.softtek.academy.ws.domain.model.Category;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.domain.model.Uom;

@Component
@Scope("prototype")
public class ItemComplexRowMapper implements ResultSetExtractor<Item>{

	@Override
	public Item extractData(ResultSet rs) throws SQLException {
		rs.next();
		
		Item item = new Item();
		
		item.setId(rs.getLong("item_id"));
		item.setDescription(rs.getString("item_description"));
		item.setFeatures(rs.getString("item_features"));
		
		Uom uom = new Uom(rs.getString("uom_id"),rs.getString("uom_description"));
		
		
		item.setUom(uom);
		
		item.setUnitPrice(rs.getLong("item_unit_price"));
		item.setImagePath(rs.getString("item_image_path"));
		item.setStock(rs.getLong("item_stock"));
		item.setActive("Y".equals(rs.getString("item_active")));
		
		List<Category> categories = new ArrayList<>();
		do {
			categories.add(new Category(rs.getLong("category_id"),rs.getString("category_description")));
		}while(rs.next());
		item.setCategories(categories);
		return item;
	}

}
