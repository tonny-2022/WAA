package com.labs.lab2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.lab2.entity.Post;
import com.labs.lab2.repo.PostRepo;
import com.labs.lab2.service.PostService;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepo postrepo;

	@Override
	public List<Post> findAllPosts() {
		
		return postrepo.findAll();
	}

	@Override
	public Post findPostById(long id) {
		
		return postrepo.findById(id).get();
	}

	@Override
	public Post savePost(Post post) {
		
		return postrepo.save(post);
	}

	@Override
	public void deletePostById(long id) {
		
		 postrepo.deleteById(id);
	}

	@Override
	public void updatePostById(Post post,long id) {
		
		postrepo.deleteById(id);
		postrepo.save(post);
	
		
	}
	
	

	

}
