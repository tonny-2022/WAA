package com.labs.lab2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.lab2.entity.Post;
import com.labs.lab2.entity.User;
import com.labs.lab2.repo.UserRepo;
import com.labs.lab2.service.UserService;


@Service
public class UserServiceImpl implements UserService {
@Autowired
	UserRepo userrepo;

	@Override
	public List<User> findAllUsers() {
		
		return userrepo.findAll();
	}

	@Override
	public User findUserById(long id) {
		
		return userrepo.findById(id).get();
	}

	@Override
	public User saveUser(User user) {
	
		return userrepo.save(user);
	}


	@Override
	public List<Post> findUserPosts(long id) {	
		User user=userrepo.findById(id).get();	
		return  user.getPosts();
	}


}
