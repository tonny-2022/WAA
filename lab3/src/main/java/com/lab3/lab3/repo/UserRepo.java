package com.lab3.lab3.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.User;



public interface UserRepo extends JpaRepository<User, Long> {

public Optional<User> findByEmail(String email);

@Query("SELECT u FROM User u WHERE SIZE(u.posts) > :numposts")	
public List<User> findAllUsersMoreThanNPosts( int numposts);

@Query("SELECT  u  FROM User u  JOIN FETCH  u.posts p  WHERE p.title=:title")
public List<User> findUsersByTitleInPosts(String title);


}
