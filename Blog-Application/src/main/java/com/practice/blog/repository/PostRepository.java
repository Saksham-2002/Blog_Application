package com.practice.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.blog.model.Category;
import com.practice.blog.model.Post;
import com.practice.blog.model.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);

}
