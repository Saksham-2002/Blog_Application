package com.practice.blog.service;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.blog.dto.UserDto;
import com.practice.blog.exception.ResourceNotFoundException;
import com.practice.blog.model.User;
import com.practice.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto dto) {
		User user = UserDtoToUser(dto);
		User savedUser = userRepo.save(user);

		return UserToUserDto(savedUser);

	}

	@Override
	public UserDto updateUser(UserDto userDto, int userId) {

		User user = userRepo.findById(userId)
				    .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
       User savedUser= userRepo.save(user);
		UserDto updatedUser = UserToUserDto(savedUser);
		return updatedUser;
	}

	@Override
	public UserDto getUserById(int userId) {

		User user = userRepo.findById(userId)
				     .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		UserDto actualUser = UserToUserDto(user);
		return actualUser;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDto> list = new ArrayList<>();

		for (User user : users) {
			UserDto dto = UserToUserDto(user);
			list.add(dto);
		}		
		return list;
	}

	@Override
	public void deleteUser(int userId) {
		User user=userRepo.findById(userId)
				  .orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		userRepo.delete(user);
	}

	public User UserDtoToUser(UserDto dto) {
		User user = this.modelMapper.map(dto, User.class);
		
		return user;
	}

	public UserDto UserToUserDto(User user) {
		UserDto dto = this.modelMapper.map(user, UserDto.class);
		
		return dto;
	}

}
