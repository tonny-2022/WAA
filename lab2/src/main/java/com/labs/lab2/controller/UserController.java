package com.labs.lab2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.lab2.entity.Post;
import com.labs.lab2.entity.User;
import com.labs.lab2.service.UserService;

@RestController
@RequestMapping("/api/v2/users")
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
	
	

}
