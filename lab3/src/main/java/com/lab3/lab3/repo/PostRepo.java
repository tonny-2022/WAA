package com.lab3.lab3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.User;



public interface PostRepo extends JpaRepository<Post, Long> {
	@Query("SELECT p from Post p where p.title=:title")
	public List<Post> findPostsByTitle(String title);
	

	
}
