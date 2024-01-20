package com.lab3.lab3.service;

import java.util.List;

import com.lab3.lab3.entity.Comment;
import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.PostDto;

public interface PostService {
	List<Post> findAllPosts();
	Post findPostById(long id);
	void deletePostById(long id);
	void updatePostById(Post  post,long id);
	void savePost(PostDto postDto);
	
	
}