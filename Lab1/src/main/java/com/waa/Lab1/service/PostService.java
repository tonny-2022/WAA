package com.waa.Lab1.service;

import java.util.List;

import com.waa.Lab1.entity.Post;

public interface PostService {
	List<Post> findAllPosts();
	Post findPostById(long id);
	Post savePost(Post post);
	void deletePostById(long id);
	void updatePostById(Post  post);
	
}
