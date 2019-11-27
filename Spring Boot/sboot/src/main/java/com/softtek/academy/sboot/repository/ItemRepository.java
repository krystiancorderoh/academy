package com.softtek.academy.sboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.academy.sboot.domain.dto.ItemFilter;
import com.softtek.academy.sboot.domain.model.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    List<ItemEntity> findByCategoryId(Long categoryId);

    List<ItemEntity> getByFilter(ItemFilter itemFilter);

}