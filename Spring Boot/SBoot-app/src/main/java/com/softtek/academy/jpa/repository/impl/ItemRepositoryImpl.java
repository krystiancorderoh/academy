package com.softtek.academy.jpa.repository.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.softtek.academy.jpa.domain.dto.ItemFilter;
import com.softtek.academy.jpa.domain.dto.NumericRange;
import com.softtek.academy.jpa.domain.model.ItemEntity;
import com.softtek.academy.jpa.repository.map.ItemComplexRowMapper;
import com.softtek.academy.jpa.repository.map.ItemSingleRowMapper;

public class ItemRepositoryImpl {

    //@Autowired
    private JdbcTemplate jdbcTemplate;

    //@Autowired
    private ObjectFactory<ItemComplexRowMapper> complexRowMapperFactory;

    //@Autowired
    private ObjectFactory<ItemSingleRowMapper> singleRowMapperFactory;


    //@Override
    public ItemEntity findOne(final Long itemId) {
        final String sql = "SELECT i.*, u.*, u.description uom_description, ci.*, c.*, c.description category_description " +
                "  FROM item i " +
                " INNER JOIN uom u ON u.id = i.uom_id " +
                "  LEFT JOIN category_item ci ON ci.item_id = i.id " +
                "  LEFT JOIN category c ON c.id = ci.category_id " +
                " WHERE i.id = ?";

        return jdbcTemplate.query(sql, new Object[]{itemId}, complexRowMapperFactory.getObject());
    }

    //@Override
    public List<ItemEntity> findByCategoryId(final Long categoryId) {
        final String sql = "SELECT i.* " +
                "  FROM item i " +
                " INNER JOIN category_item ci ON ci.item_id = i.id " +
                " WHERE ci.category_id = ?";

        return jdbcTemplate.query(sql, new Object[]{categoryId}, singleRowMapperFactory.getObject());
    }

    //@Override
    public List<ItemEntity> getByFilter(final ItemFilter filter) {
        final StringBuilder sql = new StringBuilder("SELECT * FROM ITEM " +
                "INNER JOIN CATEGORY_ITEM ON item_id = id " +
                "WHERE 1 = 1 ");

        if (StringUtils.isNotBlank(filter.getDescription())) {
            sql.append("AND description LIKE '%" + filter.getDescription() + "%' ");
        }

        if (StringUtils.isNotBlank(filter.getUomId())) {
            sql.append("AND uom_id = '" + filter.getUomId() + "' ");
        }

        NumericRange<Double> unitPrice = filter.getUnitPrice();
        if (unitPrice != null) {
            if (unitPrice.getMin() != null) {
                sql.append("AND unit_price >= " + unitPrice.getMin() + " ");
            }

            if (unitPrice.getMax() != null) {
                sql.append("AND unit_price <= " + unitPrice.getMax() + " ");
            }
        }

        if (filter.isOutOfStock()) {
            sql.append("AND stock = 0 ");
        }

        if (filter.getCategoryId() != null) {
            sql.append("AND category_id = " + filter.getCategoryId());
        }

        return jdbcTemplate.query(sql.toString(), singleRowMapperFactory.getObject());
    }
}