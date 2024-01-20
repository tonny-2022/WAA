package com.lab3.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lab3.lab3.entity.Comment;
import com.lab3.lab3.entity.Post;
import com.lab3.lab3.repo.PostRepo;

@SpringBootApplication
public class Lab3Application implements CommandLineRunner {
	
	@Autowired
	private PostRepo postRepo;

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Post post1 = new Post("Excel in real estates", "buying properties and resale  at prime times", "John Frank");
		Comment comment1 = new Comment("1234");
		Comment comment2 = new Comment("67879");
		Comment comment3 = new Comment("90865");
		
		post1.addComment(comment1);
		post1.addComment(comment2);
		post1.addComment(comment3);
		
		postRepo.save(post1);
		
		



		
	}

}
