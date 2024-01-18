package com.waa.Lab1.repo;

import java.util.List;

import com.waa.Lab1.entity.Post;

public interface PostRepo {
	List<Post> findAllPosts();
	Post findPostById(long id);
	Post savePost(Post post);
	void deletePostById(long id);
	void updatePostById(Post  post);
	

}
