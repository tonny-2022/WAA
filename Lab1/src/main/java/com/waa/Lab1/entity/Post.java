package com.waa.Lab1.entity;


public class Post {
    long id;
    String title;
    String content;
    String author;
	public Post(long id, String title, String content, String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
    


}
