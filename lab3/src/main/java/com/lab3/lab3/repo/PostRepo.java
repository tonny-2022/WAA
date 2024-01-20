package com.lab3.lab3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab3.lab3.entity.Post;



public interface PostRepo extends JpaRepository<Post, Long> {
	
}
