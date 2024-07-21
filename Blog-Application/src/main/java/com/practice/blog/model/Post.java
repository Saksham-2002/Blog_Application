package com.practice.blog.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postId;
	
	@Column(name="post_title", nullable=false)
	private String title;
	
	@Column(name="post_content", nullable=false)
	private String content;
	
	@Column(nullable=false)
	private String imageName;
	
	@Column(nullable=false)
	private Date createdDate;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
}
