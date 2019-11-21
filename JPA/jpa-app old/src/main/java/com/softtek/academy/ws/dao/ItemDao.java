package com.softtek.academy.ws.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softtek.academy.ws.domain.dto.ItemDto;
import com.softtek.academy.ws.domain.dto.ItemFilter;
import com.softtek.academy.ws.domain.model.Item;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ItemDao {
	
	private static final String SQL_SELECT_ALL = "SELECT DISTINCT i.*, UOM.id AS 'uom_id', UOM.description AS 'uom_description'\r\n"
			+ "	FROM ITEM i\r\n" + "	INNER JOIN UOM ON i.uom_id = uom.id\r\n"
			+ "	LEFT JOIN CATEGORY_ITEM ci ON i.id = ci.item_id\r\n" +
			" WHERE i.id IS NOT NULL ";

	private static final String SQL_SELECT = "SELECT i.*, UOM.id AS 'uom_id', UOM.description AS 'uom_description', c.id AS 'category_id', c.description AS 'category_description'\r\n"
			+ "	FROM ITEM i\r\n" + "	INNER JOIN UOM ON i.uom_id = uom.id\r\n"
			+ "	LEFT JOIN CATEGORY_ITEM ci ON i.id = ci.item_id\r\n"
			+ "	LEFT JOIN CATEGORY  c ON ci.category_id = c.id";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private ObjectFactory<RowMapper<Item>> rowMapperFactory;

	@Autowired
	private ObjectFactory<ResultSetExtractor<Item>> rowMapperComplexFactory;

	public List<Item> findAll() throws SQLException {
		return jdbcTemplate.query(SQL_SELECT, rowMapperFactory.getObject());
	}

	public Item findOne(Long itemId) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource("id", itemId);
		return jdbcTemplate.query(SQL_SELECT + " WHERE i.id = :id", params, rowMapperComplexFactory.getObject());
	}
	
	public List<Item> findByCategory(Long categoryId) {
		String sql = "SELECT i.*, UOM.id AS 'uom_id', UOM.description AS 'uom_description' FROM item i INNER JOIN UOM ON i.uom_id = uom.id INNER JOIN category_item ci ON ci.item_id = i.id WHERE ci.category_id = :id;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", categoryId);
		return jdbcTemplate.query(sql, params, rowMapperFactory.getObject());
	}

	public Item save(ItemDto itemDto) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("description", itemDto.getDescription());
		params.addValue("uom_id", itemDto.getUomId());
		params.addValue("unit_price", itemDto.getUnitPrice());
		params.addValue("image_path", itemDto.getImagePath());
		params.addValue("stock", itemDto.getStock());
		params.addValue("active", itemDto.getActive() ? "Y" : "N");
		final String sql = "INSERT INTO city(description, uom_id, unit_price, image_path, stock, active) VALUES(:description, :uom_id, :unit_price, :image_path, :stock, :active)";
		jdbcTemplate.update(sql, params);
		final String sqlInsert = SQL_SELECT + " WHERE city.description = :description";
		return jdbcTemplate.queryForObject(sqlInsert, params, rowMapperFactory.getObject());
	}

	public Item update(Long cityId, ItemDto itemDto) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("description", itemDto.getDescription());
		params.addValue("uom_id", itemDto.getUomId());
		params.addValue("unit_price", itemDto.getUnitPrice());
		params.addValue("image_path", itemDto.getImagePath());
		params.addValue("stock", itemDto.getStock());
		params.addValue("active", itemDto.getActive() ? "Y" : "N");
		final String sql = "UPDATE item set description = :description, uom_id, unit_price, image_path, stock, active WHERE item.id = :id";
		jdbcTemplate.update(sql, params);
		return findOne(cityId);
	}

	public Boolean delete(Long itemId) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource("id", itemId);
		return jdbcTemplate.update("DELETE FROM item WHERE i.id = :id", params) > 0;
	}

	public List<Item> findByFilter(ItemFilter itemFilter) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		String queryParams = "";
		if(itemFilter.getOutOfStock() != null) {
			queryParams += " AND active = " + (itemFilter.getOutOfStock() ? "'Y'":"'N'");
		}
		if(itemFilter.getCategoryId() != null) {
			params.addValue("category_id", itemFilter.getCategoryId());
			queryParams += " AND category_id = :category_id ";
		}
		if(itemFilter.getDescription()!= null) {
			queryParams += " AND i.description LIKE '%" + itemFilter.getDescription() + "%'";
		}
		if(itemFilter.getUomId() != null) {
			params.addValue("uom_id", itemFilter.getUomId());
			queryParams += " AND uom_id = :uom_id ";
		}
		log.info(SQL_SELECT_ALL + queryParams);
		return jdbcTemplate.query(SQL_SELECT_ALL + queryParams, params,rowMapperFactory.getObject());
	}

	public Item updateImagePath(Long itemId, String serverPath) throws SQLException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", itemId);
		params.addValue("image_path", serverPath);
		jdbcTemplate.update("UPDATE item set image_path = :image_path WHERE item.id = :id", params);
		return findOne(itemId);
	}
}
