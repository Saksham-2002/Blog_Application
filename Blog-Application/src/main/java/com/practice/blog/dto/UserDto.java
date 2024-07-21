package com.practice.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	
	private int id;
	
	@NotEmpty(message= "Enter a valid name")
	@Size(min=4, message="Name should be minimum of 4 characters")
	private String name;
	
	@Email(message= "Enter a valid email id")
	private String email;
	
	@NotEmpty(message="Enter a valid password")
	@Size(min=4, max=12, message="Password should be minimum of 4 and maximum of 12 characters")
	private String password;
	
	@NotEmpty(message="Eneter something about yourself")
	private String about;
}
