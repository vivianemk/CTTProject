package com.ctt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctt.project.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
