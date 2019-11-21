package com.softtek.academy.jpa.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softtek.academy.jpa.domain.model.OrderEntity;
import com.softtek.academy.jpa.domain.model.StateEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	@Query(value="select o from OrderEntity o where o.orderDate < :actualDay and o.statusId <> '2400' order by o.orderDate desc")
	List<OrderEntity> getOrdersToToday(@Param("actualDay") LocalDateTime actualDay);
}