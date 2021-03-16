package com.ctt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctt.project.entity.ClientOrder;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long>{

}
