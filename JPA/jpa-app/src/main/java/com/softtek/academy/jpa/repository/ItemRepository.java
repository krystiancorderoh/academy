package com.softtek.academy.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softtek.academy.jpa.domain.dto.ItemFilter;
import com.softtek.academy.jpa.domain.model.ItemEntity;
import com.softtek.academy.jpa.domain.model.OrderEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

	@Query(value="select * from item as i " +
	" join CATEGORY_ITEM as ci on ci.item_id = i.id " +
	" where ci.category_id = :categoryId ", nativeQuery=true)
	List<ItemEntity> findByCategoryId(@Param("categoryId") Long categoryId);
//
//    List<ItemEntity> getByFilter(ItemFilter itemFilter);

    @Query(value="Select TOP (10) "
    	+ " i.id,i.description,i.active,i.features,i.image_path,i.stock,i.unit_price,i.uom_id "
    	+ " from ITEM as i "
    	+ " join ORDER_LINE as ol on i.id = ol.item_id "
    	+ " where ol.status_id <> '3400' and ol.create_date > :aWeekAgo "
    	+ " group by "
    	+ " i.id,i.description,i.active,i.features,i.image_path,i.stock,i.unit_price,i.uom_id "
    	+ " order by sum(ol.quantity) desc", nativeQuery=true)
	List<ItemEntity> getTopTenWeek(@Param("aWeekAgo")LocalDateTime aWeekAgo);

}