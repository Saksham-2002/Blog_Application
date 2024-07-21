package com.practice.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.blog.dto.CategoryDto;
import com.practice.blog.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto createdCategory=categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{categoryId}")
	public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable int categoryId)
	{
		CategoryDto updatedCategory=categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}
	
	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId)
	{
		 CategoryDto category=categoryService.getCategoryById(categoryId);
		 return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		List<CategoryDto> categories=categoryService.getAllCategory();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable int categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>("Category is deleted with category id " + categoryId, HttpStatus.OK);
	}
	
	
}
