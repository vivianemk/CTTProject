package com.ctt.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ctt.project.entity.Category;
import com.ctt.project.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("select p from Product p where p.category = :id")
	List<Product> findByCategory(@Param("id") Category category);
	
//	@Query("select p from Product p limit 12")
//	List<Product> getTwelve;
}
