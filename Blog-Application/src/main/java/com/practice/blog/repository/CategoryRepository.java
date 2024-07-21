package com.practice.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.blog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	
}
