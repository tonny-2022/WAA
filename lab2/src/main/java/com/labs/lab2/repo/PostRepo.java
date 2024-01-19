package com.labs.lab2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lab2.entity.Post;


public interface PostRepo extends JpaRepository<Post, Long> {
	/*List<Post> findAllPosts();
	Post findPostById(long id);
	Post savePost(Post post);
	void deletePostById(long id);
	void updatePostById(Post  post);*/
	

}
