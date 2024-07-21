package com.practice.blog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.blog.dto.PostDto;
import com.practice.blog.exception.ResourceNotFoundException;
import com.practice.blog.model.Category;
import com.practice.blog.model.Post;
import com.practice.blog.model.User;
import com.practice.blog.repository.CategoryRepository;
import com.practice.blog.repository.PostRepository;
import com.practice.blog.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public PostDto createPost(PostDto postDto, int userId, int categoryId) {
	
		User user = userRepo.findById(userId)
			    .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		
		Category category = categoryRepo.findById(categoryId)
			    .orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		
		Post post=postDtoToPost(postDto);
		
		post.setImageName("Default.png");
		post.setCreatedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post createdPost=postRepo.save(post);
		return postToDto(createdPost);
		
	}

	@Override
	public PostDto updatePost(PostDto post, int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(int postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDto> getPostById(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByUser(int userId) {
		
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "user id", userId));
		List<Post> posts=postRepo.findByUser(user);
		List<PostDto>postDtos= new ArrayList<>();

		for(Post post:posts)
		{
			PostDto postDto=postToDto(post);
			postDtos.add(postDto);
		}
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByCategory(int categoryId) {
		Category category=categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "category id", categoryId));
		List<Post> posts=postRepo.findByCategory(category);
		List<PostDto>postDtos= new ArrayList<>();

		for(Post post:posts)
		{
			PostDto postDto=postToDto(post);
			postDtos.add(postDto);
		}
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PostDto postToDto(Post post)
	{
		PostDto dto=modelMapper.map(post, PostDto.class);
		return dto;
	}
	
	public Post postDtoToPost(PostDto dto)
	{
		Post post=modelMapper.map(dto, Post.class);
		return post;
	}

}
