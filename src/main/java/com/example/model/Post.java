package com.example.model;

public class Post {
	private int id;
	private int user_id;
	private String img;
	private String content;
	private String username;
	private String avatar;
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public int getUserId() {
		return this.user_id;
	}
	
	public String getImg() {
		return this.img;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
}
