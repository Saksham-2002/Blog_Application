package com.practice.blog.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="user_name", nullable=false, length=100)
	private String name;
	
	@Column(nullable=false, length=100)
	private String email;
	
	@Column(nullable=false, length=100)
	private String password;
	
	
	private String about;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> post;
}
