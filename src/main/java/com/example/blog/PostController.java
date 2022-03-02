package com.example.blog;


import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.connection.QueryPost;
import com.example.model.Post;

// import library

// import model

import com.google.gson.Gson;

@CrossOrigin(origins = "http://localhost:3000")
@Service
@RestController
@RequestMapping("/posts")

public class PostController {
	
	QueryPost qu = new QueryPost();

	@PostMapping("/add")
	public int add(@RequestBody String data) throws SQLException {
		var gson = new Gson();
		Post post = gson.fromJson(data, Post.class);
		return qu.addPost(post);
	}
	
	@GetMapping("/load_all")
	public List<Post> loadAllPost() throws SQLException{
		return qu.loadAllPost();
	}
	
	@GetMapping("/load/users/{id}")
	public List<Post> getUser(@PathVariable int id) throws SQLException {
		return qu.loadPostByUserId(id);
	}
}
