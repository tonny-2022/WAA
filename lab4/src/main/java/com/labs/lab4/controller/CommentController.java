package com.labs.lab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.lab4.entity.Comment;
import com.labs.lab4.service.CommentService;



@RestController
@RequestMapping("/api/v4/comments")
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
