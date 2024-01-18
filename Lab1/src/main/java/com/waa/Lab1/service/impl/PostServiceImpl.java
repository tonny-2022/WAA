package com.waa.Lab1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waa.Lab1.entity.Post;
import com.waa.Lab1.repo.PostRepo;
import com.waa.Lab1.service.PostService;
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepo postrepo;

	@Override
	public List<Post> findAllPosts() {
		
		return postrepo.findAllPosts();
	}

	@Override
	public Post findPostById(long id) {
		
		return postrepo.findPostById(id);
	}

	@Override
	public Post savePost(Post post) {
		
		return postrepo.savePost(post);
	}

	@Override
	public void deletePostById(long id) {
		
		 postrepo.deletePostById(id);
	}

	@Override
	public void updatePostById(Post post) {
		postrepo.updatePostById(post);
	
		
	}
	
	

	

}
