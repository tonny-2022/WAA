package com.lab3.lab3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab3.lab3.entity.Comment;
import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.PostDto;
import com.lab3.lab3.repo.PostRepo;
import com.lab3.lab3.service.PostService;

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
	public Post updatePostById(Post post,long id) {
		
		Post postToUpdate=postrepo.findById(id).orElse(null);
		if(postToUpdate!=null){
			postToUpdate.setAuthor(post.getAuthor());
			postToUpdate.setContent(post.getContent());
			postToUpdate.setTitle(post.getTitle());
		   return postrepo.save(postToUpdate);
		}
		else {
			
		return null;	
		}
	
		
	}

	@Override
	public List<Post> findPostsByTitle(String title) {
		
		return postrepo.findPostsByTitle(title);
	}

	

	
	

	

}
