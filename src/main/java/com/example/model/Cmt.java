package com.example.model;

import java.sql.Timestamp;

public class Cmt {

	private int user_id;
	private int post_id;
	private String content;
	private Timestamp time;
	private String avatar;
	private String username;
	
	
	public void setUserId(int id) {
		this.user_id = id;
	}
	
	public void setPostId(int id) {
		this.post_id = id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public void setUsername(String name) {
		this.username = name;
	}
	
	
	public int getUserId() {
		return this.user_id;
	}
	
	public int getPostId() {
		return this.post_id;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public Timestamp getTime() {
		return this.time;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
	
	public String getUsername() {
		return this.username;
	}
}
