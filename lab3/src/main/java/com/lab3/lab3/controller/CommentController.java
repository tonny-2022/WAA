package com.lab3.lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab3.lab3.entity.Comment;
import com.lab3.lab3.entity.Post;
import com.lab3.lab3.service.CommentService;

@RestController
@RequestMapping("/api/v3/comments")
public class CommentController {
	
@Autowired
CommentService commentservice;


@PostMapping("/post/{id}")
 public void addCommentToPost(@PathVariable long id,@RequestBody Comment comment) {
	
	commentservice.saveComment(id,comment);
}
@GetMapping
public List<Comment> findAllComments(){
	
	return commentservice.findAllComments();
}


}
