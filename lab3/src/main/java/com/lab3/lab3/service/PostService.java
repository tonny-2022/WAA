package com.lab3.lab3.service;

import java.util.List;

import com.lab3.lab3.entity.Comment;
import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.PostDto;
import com.lab3.lab3.entity.User;

public interface PostService {
	List<Post> findAllPosts();
	Post findPostById(long id);
	void deletePostById(long id);
	Post updatePostById(Post  post,long id);
	void savePost(PostDto postDto);
	List<Post>findPostsByTitle(String title);

	
	
}
