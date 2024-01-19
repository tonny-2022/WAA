package com.labs.lab2.service;

import java.util.List;

import com.labs.lab2.entity.Post;
import com.labs.lab2.entity.User;

public interface UserService {
	List<User> findAllUsers();
	User findUserById(long id);
	User saveUser(User post);
	List<Post>  findUserPosts(long id);
	

}
