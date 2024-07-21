package com.practice.blog.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	
	
	@Column(nullable=false)
	private String categoryTitle;
	
	@Column(nullable=false)
	private String categoryDescription;
	
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	private List<Post> post;
}
