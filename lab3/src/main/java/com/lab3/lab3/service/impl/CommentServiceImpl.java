package com.lab3.lab3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lab3.lab3.entity.Comment;
import com.lab3.lab3.entity.Post;
import com.lab3.lab3.repo.CommentRepo;
import com.lab3.lab3.repo.PostRepo;
import com.lab3.lab3.service.CommentService;

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
	@Override
	public List<Comment> findCommentsByPostId(long id) {
		
		return commentrepo.findCommentsByPostId(id);
		
	}



}
