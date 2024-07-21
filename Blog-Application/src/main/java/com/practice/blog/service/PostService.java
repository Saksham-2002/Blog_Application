package com.practice.blog.service;

import java.util.List;

import com.practice.blog.dto.PostDto;


public interface PostService {

	   PostDto createPost(PostDto postDto, int userId, int categoryId);
	   
	   
	   PostDto updatePost(PostDto post, int postId);
	   
	   
	   void deletePost(int postId);
	   
	   
	   List<PostDto> getPostById(int postId);
	   
	   
	   List<PostDto> getAllPost();
	   
	   
	   List<PostDto> getPostByUser(int userId);
	   
	   
	   List<PostDto> getPostByCategory(int categoryId);
	   
	   
	   List<PostDto> getPostByKeyword(String keyword);
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
}
