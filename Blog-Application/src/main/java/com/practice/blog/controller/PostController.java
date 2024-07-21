package com.practice.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.practice.blog.dto.PostDto;
import com.practice.blog.service.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/posts")
public class PostController {

	@Autowired
	 private PostService postService;
	
	@PostMapping("/create")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @RequestParam int userId, @RequestParam int categoryId)
	{
		PostDto createdPost=postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostsByUser(@Valid @PathVariable int userId)
	{
		List<PostDto> posts= postService.getPostByUser(userId);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategory(@Valid @PathVariable int categoryId)
	{
		List<PostDto> posts= postService.getPostByCategory(categoryId);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
}
