package com.example.blog;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.connection.QueryUser;
import com.example.model.User;

// import library

// import model

import com.google.gson.Gson;

@CrossOrigin(origins = "http://localhost:3000")
@Service
@RestController
@RequestMapping("/users")
public class WelcomeController {

	public QueryUser qu = new QueryUser();
	public User user = new User();
	public List<User> list = new ArrayList<User>();
	public WelcomeController() {
		
	}
	
	@PostMapping("/add")
	public User add(@RequestBody String data) throws SQLException {
		var gson = new Gson();
		user = gson.fromJson(data, User.class);
		int check = qu.checkUserExist(user.getUsername(), user.getEmail());
		if (check == 1) {
			if (qu.addUser(user) == 1) {
				user = qu.getUserByUsername(user.getUsername());
				return user;
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	@GetMapping("/get/{id}")
	public User getUser(@PathVariable int id) throws SQLException {
		return qu.getUserById(id);
	}
	
	@PostMapping("/get")
	public User getUserLogin(@RequestBody String data) throws SQLException {
		var gson = new Gson();
		user = gson.fromJson(data, User.class);
		user = qu.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		return user;
	}
	
	@PostMapping("/update")
	public User settingUser(@RequestBody String data) throws SQLException {
		var gson = new Gson();
		user = gson.fromJson(data, User.class);
		if (qu.updateUser(user) == 1) {
			user = qu.getUserByUsername(user.getUsername());
			return user;
		}
		return null;
	}
	@GetMapping("/load_all")
	public List<User> loadAllUser() throws SQLException {
		list = qu.getAllUser();
		return list;
	}
}
