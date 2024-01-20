package com.lab3.lab3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.PostDto;
import com.lab3.lab3.entity.User;
import com.lab3.lab3.repo.UserRepo;
import com.lab3.lab3.service.UserService;

import jakarta.transaction.Transactional;


@Service
@Transactional
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

	@Override
	public void deleteUser(long id) {
		userrepo.deleteById(id);
		
	}

	@Override
	public List<User> findAllUsersMoreThanNPosts(int numposts) {
		
		return userrepo.findAllUsersMoreThanNPosts(numposts);
	}

	@Override
	public void savePost(PostDto postDto,long userid) {
		User user=findUserById(userid);
		Post post= new Post();
		post.setAuthor(postDto.getAuthor());
		post.setTitle(postDto.getAuthor());
		post.setContent(postDto.getContent());
		user.addPostToUser(post);
		}


}
