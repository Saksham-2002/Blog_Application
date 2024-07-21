package com.practice.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
