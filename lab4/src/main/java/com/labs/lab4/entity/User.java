package com.labs.lab4.entity;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.sql.ast.tree.from.MappedByTableGroup;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
    String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    List<Post> posts = new ArrayList<Post>();
	public User( String name, List<Post> posts) {
		super();
		//this.id = id;
		this.name = name;
		this.posts = posts;
	}
	public User() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public void addPostToUser(Post post) {
		posts.add(post);
		
	}


}
