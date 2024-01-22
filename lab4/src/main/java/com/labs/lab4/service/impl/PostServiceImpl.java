package com.labs.lab4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.PostDto;
import com.labs.lab4.repo.PostRepo;
import com.labs.lab4.service.PostService;

import jakarta.transaction.Transactional;

@Service
@Transactional
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
	public void savePost(PostDto postDto ) {
		Post post = new Post();
		post.setAuthor(postDto.getAuthor());
	    post.setTitle(postDto.getTitle());
	    post.setContent(postDto.getContent());;
		postrepo.save(post);
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

	@Override
	public List<Post> findPostsByTitle(String title) {
		
		return postrepo.findPostsByTitle(title);
	}

	

	
	

	

}
