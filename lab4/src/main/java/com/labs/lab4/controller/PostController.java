package com.labs.lab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.PostDto;
import com.labs.lab4.service.PostService;



@RestController
@RequestMapping("/api/v4/posts")
public class PostController {
	@Autowired
	PostService postservice;
	
	@GetMapping
	public List<Post> findAllPosts() {
		
	 return postservice.findAllPosts();	
	}
	
	@GetMapping("/{id}")
	 Post findPostById(@PathVariable long id){
		
		return postservice.findPostById(id);
	} 
	@PostMapping
	public void savePost(@RequestBody PostDto postDto) {
		
		postservice.savePost(postDto) ;
	}
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable long id) {
		
		postservice.deletePostById(id);
	}
	@PutMapping("/{id}")
	public Post updatePost(@RequestBody Post post, @ PathVariable long id) {
		
		postservice.updatePostById(post,id);
		return post;
	}
	
  @GetMapping("/post-with-title/{title}")
   public List<Post> findPostsByTitle(@PathVariable String title) {
		
		return postservice.findPostsByTitle(title);
	}

}
