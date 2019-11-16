package com.softtek.academy.ws.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.domain.dto.ItemFilter;
import com.softtek.academy.ws.domain.model.City;
import com.softtek.academy.ws.domain.model.Item;
import com.softtek.academy.ws.exception.NotFoundException;

@Repository
public class ItemDao {
	
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
    private ObjectFactory<ResultSetExtractor<Item>> complexRowMapperFactory;
	
	@Autowired
    private ObjectFactory<RowMapper<Item>> rowMapperFactory;
	
	public Item findOne(Long id) throws SQLException {
    	
    	String sql = "SELECT i.id AS item_id, i.description AS item_description, i.features AS item_features, i.uom_id, UOM.description AS uom_description, i.unit_price AS item_unit_price, " + 
    			" i.image_path AS item_image_path, i.stock AS item_stock, i.active AS item_active, CATEGORY.description AS category_description, CATEGORY.id AS category_id" + 
    			" FROM  ITEM as i LEFT OUTER JOIN" + 
    			" UOM ON i.uom_id = UOM.id INNER JOIN" + 
    			" CATEGORY_ITEM ON CATEGORY_ITEM.item_id = i.id INNER JOIN" + 
    			" CATEGORY ON CATEGORY.id = CATEGORY_ITEM.category_id"
    			+ " where i.id = :id";
    			
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        Item item = null;
        try {
        	item = jdbcTemplate.query(sql, params, complexRowMapperFactory.getObject());
        }catch(EmptyResultDataAccessException e) {
        	throw new NotFoundException("No data found for ItemId: " + id);
        }
        return item;
    	
    }
	
	public List<Item> findByCategoryId(Long categoryId){
		
		String sql = "SELECT i.id item_id,i.description item_description,i.id AS item_id, i.description AS item_description, i.features AS item_features, i.unit_price AS item_unit_price," + 
				"                         i.image_path AS item_image_path, i.stock AS item_stock, i.active AS item_active FROM item i INNER JOIN category_item ci ON ci.item_id = i.id WHERE ci.category_id = :categoryId";
		MapSqlParameterSource params = new MapSqlParameterSource("categoryId", categoryId);
		return jdbcTemplate.query(sql, params, rowMapperFactory.getObject());
		
	}
	
	public List<Item> findByItemFilter(ItemFilter itemFilter){
		
		String where = "";
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		
		if(itemFilter.getDescription()!=null) {
			if(where != "") {
				where += " and i.description like (:description)";
			}else {
				where += " where i.description like (:description)";
			}
			params.addValue("description", "%"+itemFilter.getDescription()+"%");
		}
		if(itemFilter.getOutOfStock()!=null) {
			if(where != "") {
				if(itemFilter.getOutOfStock()) {
					where += " and i.stock = 0";
				}
				
			}else {
				if(itemFilter.getOutOfStock()) {
					where += " where i.stock = 0";
				}
			}
		}
		if(itemFilter.getUomId() != null) {
			if(where != "") {
				where += " and i.uom_id = :uomId";
			}else {
				where += " where i.uom_id = :uomId";
			}
			params.addValue("uomId", itemFilter.getUomId());
		}
		if(itemFilter.getCategoryId() != null) {
			if(where != "") {
				where += " and ci.category_id = :categoryId";
			}else {
				where += " where ci.category_id = :categoryId";
			}
			params.addValue("categoryId", itemFilter.getCategoryId());
		}
		
		String sql = "SELECT i.id item_id,i.description item_description,i.id AS item_id, i.description AS item_description, i.features AS item_features, i.unit_price AS item_unit_price," + 
				"i.image_path AS item_image_path, i.stock AS item_stock, i.active AS item_active FROM item i INNER JOIN category_item ci ON ci.item_id = i.id ";
		System.out.println(where);
		sql+=where;
		
		return jdbcTemplate.query(sql,params, rowMapperFactory.getObject());
		
	}

	
	public void updateImagePath(Long id, String path) {
		
		String sql = "UPDATE Item Set image_path = :path WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        params.addValue("path", path);
        
        jdbcTemplate.update(sql, params);
        
        
		
	}
	
//	public List<Item> findAll() throws SQLException {
//
//		return jdbcTemplate.query("Select * From ItemFull", rowMapperFactory.getObject());
//
//	}
	

}
