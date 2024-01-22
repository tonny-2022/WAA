package com.labs.lab4.service;

import java.util.List;


import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.PostDto;
import com.labs.lab4.entity.User;

public interface UserService {
	List<User> findAllUsers();
	User findUserById(long id);
	User saveUser(User post);
	List<Post>  findUserPosts(long id);
	void deleteUser(long id);
	public List<User> findAllUsersMoreThanNPosts(int numposts);
	void savePost(PostDto postDto,long userid);
	public List<User> findUsersByTitleInPosts(String title);
}
