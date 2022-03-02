package com.example.model;


public class User {
	private int id;
	private String username;
	private String email;
	private String avatar;
	private String gender;
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getAvatar() {
		return this.avatar;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getGender() {
		return this.gender;
	}
}
