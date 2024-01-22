package com.labs.lab4.service;

import java.util.List;

import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.PostDto;



public interface PostService {
	List<Post> findAllPosts();
	Post findPostById(long id);
	void deletePostById(long id);
	void updatePostById(Post  post,long id);
	void savePost(PostDto postDto);
	List<Post>findPostsByTitle(String title);

	
	
}
