package com.labs.lab4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.lab4.annotations.ExecutionTime;
import com.labs.lab4.entity.Post;
import com.labs.lab4.entity.PostDto;
import com.labs.lab4.entity.User;
import com.labs.lab4.service.UserService;





@RestController
@RequestMapping("/api/v4/users")
public class UserController {
	
@Autowired
UserService userService;

@GetMapping
public List<User> findAllUsers(){
	
	return userService.findAllUsers();
}
@GetMapping("/{id}")
@ExecutionTime
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

@GetMapping("/{numposts}/userposts")
public List<User> findAllUsersMoreThanNPosts(@PathVariable int numposts){
	
	return userService.findAllUsersMoreThanNPosts(numposts);
	
}
	
@PostMapping("/{id}/post")
public void savePost(@RequestBody PostDto postDto, @PathVariable long id) {
	
	userService.savePost(postDto,id) ;
}
@GetMapping("/by-post-title/{title}")
public List<User> findUsersByTitleInPosts(@PathVariable String title){
	
	return userService.findUsersByTitleInPosts(title);
}
	

}
