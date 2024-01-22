package com.labs.lab4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.labs.lab4.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {
	@Query("SELECT p from Post p where p.title=:title")
	public List<Post> findPostsByTitle(String title);
	

	
}
