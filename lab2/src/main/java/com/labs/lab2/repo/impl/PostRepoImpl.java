package com.labs.lab2.repo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.labs.lab2.entity.Post;
import com.labs.lab2.repo.PostRepo;


@Repository
public class PostRepoImpl{

	/*private static List <Post> postList= new ArrayList<>();
	private static int postCount=0;
	static {
		postList.add(new Post(++postCount, "How to become best java programmer", "daily practice","Gideon"));
		postList.add(new Post(++postCount, "Best Sport in America", "American football","Tonny"));	
		postList.add(new Post(++postCount, "Excel in real estate", "buying proprties and resale them ","Frank"));
		postList.add(new Post(++postCount, "How to bcome rich", "Work hard","Jonah"));
	
	}
	
	@Override
	public List<Post> findAllPosts() {
	
		return postList;
	}

	@Override
	public Post findPostById(long id) {
		Predicate<? super Post> predicate=user->user.getId()==id;
		return postList.stream().filter(predicate).findFirst().get();
	}

	@Override
	public Post savePost(Post post) {
		
		post.setId(++postCount);
		postList.add(post);
		
		return post;
	}

	@Override
	public void deletePostById(long id) {
		Predicate<? super Post> predicate=post->post.getId()==id;
		postList.removeIf(predicate);
	}

	@Override
	public void updatePostById(Post post) {
		
		deletePostById(post.getId());
		postList.add(post);
		
	    
	}*/

}
