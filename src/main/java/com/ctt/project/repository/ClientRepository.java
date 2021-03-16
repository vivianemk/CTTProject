package com.ctt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctt.project.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	

}
