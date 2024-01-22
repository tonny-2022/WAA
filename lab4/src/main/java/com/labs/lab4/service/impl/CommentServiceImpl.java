package com.labs.lab4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.lab4.entity.Comment;
import com.labs.lab4.entity.Post;
import com.labs.lab4.repo.CommentRepo;
import com.labs.lab4.repo.PostRepo;
import com.labs.lab4.service.CommentService;



@Service
public class CommentServiceImpl  implements CommentService{
  @Autowired
  CommentRepo commentrepo;
  @Autowired
  PostRepo postrepo;
	@Override
	public Comment saveComment(long postid,Comment comment) {
		
		Post post=postrepo.findById(postid).get();
		post.addComment(comment);
		postrepo.save(post);
		return comment;
		
	}
	@Override
	public List<Comment> findAllComments() {
		
		return commentrepo.findAll();
	}



}
