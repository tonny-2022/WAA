package com.lab3.lab3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab3.lab3.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
