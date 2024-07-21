package com.practice.blog.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.practice.blog.dto.CategoryDto;



public interface CategoryService {

	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId);
	
	public List<CategoryDto> getAllCategory();
	
	public CategoryDto getCategoryById(int categoryId);
	
	public void deleteCategory(int categoryId);
	
	
	
	
	
}
