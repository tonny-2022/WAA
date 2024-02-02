package com.lab3.lab3.entity;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.sql.ast.tree.from.MappedByTableGroup;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    private String email;
    private String password;
    private String firstname;
    private String lastname;  
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    List<Post> posts = new ArrayList<Post>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles= new ArrayList<Role>();
	public User( String name, List<Post> posts,String email,String password,String firstname,String lastname) {
		super();

		this.name = name;
		this.posts = posts;
		this.email=email;
		this.password=password;
		this.lastname=lastname;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


}
