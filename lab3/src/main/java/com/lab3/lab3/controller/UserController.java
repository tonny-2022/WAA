package com.lab3.lab3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab3.lab3.entity.Post;
import com.lab3.lab3.entity.PostDto;
import com.lab3.lab3.entity.User;
import com.lab3.lab3.service.UserService;



@RestController
@RequestMapping("/api/v3/users")
public class UserController {
	
@Autowired
UserService userService;

@GetMapping
public List<User> findAllUsers(){
	
	return userService.findAllUsers();
}
@GetMapping("/{id}")
public User findUserById(@PathVariable long  id) {
	
	return userService.findUserById(id);
}
@PostMapping
public void saveUser(@RequestBody User user) {
	
	userService.saveUser(user);
}
@GetMapping({"/{id}/posts"})
public List<Post> findUserPost(@PathVariable long id) {
	
	return userService.findUserPosts(id);
}
	
@DeleteMapping("/{id}")
public void deleteUserById(@PathVariable long userid) {
	
	userService.deleteUser(userid);
}

@GetMapping("/{count}/posts")
public List<User> findAllUsersMoreThanNPosts(@PathVariable int count){
	
	return userService.findAllUsersMoreThanNPosts(count);
	
}
	
@PostMapping("/{id}/post")
public void savePost(@RequestBody PostDto postDto, @PathVariable long id) {
	
	userService.savePost(postDto,id) ;
}

	

}
