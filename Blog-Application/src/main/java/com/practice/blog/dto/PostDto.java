package com.practice.blog.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	@NotEmpty(message="Post title cannot be empty")
	private String title;
	
	@NotEmpty(message="Post content cannot be empty")
	private String content;
	
	
	private String imageName;
	
	private Date createdDate;
	
	private UserDto user;
	
	private CategoryDto category;
	
}
