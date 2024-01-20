package com.lab3.lab3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lab3.lab3.entity.User;



public interface UserRepo extends JpaRepository<User, Long> {


@Query("SELECT u FROM User u WHERE SIZE(u.posts) > :count")	
public List<User> findAllUsersMoreThanNPosts( int count);


}
