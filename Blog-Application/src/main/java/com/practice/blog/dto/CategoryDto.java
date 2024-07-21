package com.practice.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int categoryId;
	
	@NotEmpty(message="enter a valid category title")
	@Size(min=4, max=12, message="Category title can be minimum of 4 characters and maximum of 12 characters")
	private String categoryTitle;
	
	@NotEmpty(message="enter a valid category discription")
	@Size(min=4, max=50, message="Category Description can be minimum of 4 characters and maximum of 50 characters")
	private String categoryDescription;
}
