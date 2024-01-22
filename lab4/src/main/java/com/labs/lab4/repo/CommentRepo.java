package com.labs.lab4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lab4.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
