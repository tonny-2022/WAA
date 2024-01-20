package com.lab3.lab3.service;

import java.util.List;

import com.lab3.lab3.entity.Comment;
import com.lab3.lab3.entity.Post;


public interface CommentService {
	
	Comment saveComment(long postid,Comment comment);
	List<Comment> findAllComments();



}
