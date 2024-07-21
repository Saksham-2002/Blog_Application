package com.practice.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.blog.dto.CategoryDto;
import com.practice.blog.exception.ResourceNotFoundException;
import com.practice.blog.model.Category;
import com.practice.blog.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category=dtoToCategory(categoryDto);
		Category savedCategory=categoryRepo.save(category);
		return categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
		
		        Category category=categoryRepo.findById(categoryId)
		        		   .orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
	
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category savedCategory=categoryRepo.save(category);
		return categoryToDto(savedCategory);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> list=categoryRepo.findAll();
		
		List<CategoryDto> result=new ArrayList<>();
		for(Category category:list)
		{
			CategoryDto dto=categoryToDto(category);
			result.add(dto);
		}
		
		return result;
	}

	@Override
	public CategoryDto getCategoryById(int categoryId) {
		
		Category category=categoryRepo.findById(categoryId)
				       .orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		return categoryToDto(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		
		Category category=categoryRepo.findById(categoryId)
			       .orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		categoryRepo.delete(category);	
	}

	
	public CategoryDto categoryToDto(Category category)
	{
	  CategoryDto dto= this.modelMapper.map(category, CategoryDto.class);
	  return dto;
	}
	
	public Category dtoToCategory(CategoryDto dto)
	{
	  Category category= this.modelMapper.map(dto, Category.class);
	  return category;
	}
	
	
	

}
