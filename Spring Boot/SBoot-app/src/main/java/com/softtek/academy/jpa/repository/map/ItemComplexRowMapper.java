package com.softtek.academy.jpa.repository.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.softtek.academy.jpa.domain.model.CategoryEntity;
import com.softtek.academy.jpa.domain.model.ItemEntity;
import com.softtek.academy.jpa.domain.model.UomEntity;

@Component
@Scope("prototype")
public class ItemComplexRowMapper implements ResultSetExtractor<ItemEntity> {

    @Override
    public ItemEntity extractData(final ResultSet rs) throws SQLException {
        rs.next();

        UomEntity uom = new UomEntity();
        uom.setId(rs.getString("uom_id"));
        uom.setDescription(rs.getString("uom_description"));

        ItemEntity item = new ItemEntity();
        item.setId(rs.getLong("item_id"));
        item.setDescription(rs.getString("description"));
        item.setFeatures(rs.getString("features"));
        item.setUom(uom);
        item.setUnitPrice(rs.getDouble("unit_price"));
        item.setImagePath(rs.getString("image_path"));
        item.setStock(rs.getLong("stock"));
        item.setActive(rs.getString("active").equals("Y"));

        List<CategoryEntity> categories = new ArrayList<>();
        do {
            CategoryEntity cat = new CategoryEntity();
            cat.setId(rs.getLong("category_id"));
            cat.setDescription(rs.getString("category_description"));

            categories.add(cat);
        } while (rs.next());

        item.setCategories(categories);

        return item;
    }

}
