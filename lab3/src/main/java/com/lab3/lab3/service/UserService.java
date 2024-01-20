package com.lab3.lab3.service;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.PostDto;
import com.lab3.lab3.entity.User;



public interface UserService {
	List<User> findAllUsers();
	User findUserById(long id);
	User saveUser(User post);
	List<Post>  findUserPosts(long id);
	void deleteUser(long id);
	public List<User> findAllUsersMoreThanNPosts(int numposts);
	void savePost(PostDto postDto,long userid);

}
