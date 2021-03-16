package com.ctt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctt.project.entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long>{

}
