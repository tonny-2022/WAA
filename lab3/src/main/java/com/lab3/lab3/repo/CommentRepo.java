package com.lab3.lab3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lab3.lab3.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {
	@Query("SELECT c from Comment c  where c.post.id=:post_id")
	public List<Comment> findCommentsByPostId(long post_id);
}
