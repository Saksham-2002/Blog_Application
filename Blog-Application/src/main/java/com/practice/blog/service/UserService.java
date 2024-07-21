package com.practice.blog.service;

import java.util.List;

import com.practice.blog.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	 
	UserDto updateUser(UserDto user, int userId);
	
	UserDto getUserById(int userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(int userId);
	
	
	
}
