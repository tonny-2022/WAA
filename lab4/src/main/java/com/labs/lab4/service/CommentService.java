package com.labs.lab4.service;

import java.util.List;

import com.labs.lab4.entity.Comment;




public interface CommentService {
	
	Comment saveComment(long postid,Comment comment);
	List<Comment> findAllComments();



}
