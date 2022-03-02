package com.example.blog;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.connection.QueryCmt;
import com.example.model.Cmt;
import com.google.gson.Gson;

@CrossOrigin(origins = "http://localhost:3000")
@Service
@RestController
@RequestMapping("/cmts")

public class CmtController {
	
	QueryCmt qu = new QueryCmt();

	@PostMapping("/add")
	public int add(@RequestBody String data) throws SQLException {
		var gson = new Gson();
		Cmt cmt = gson.fromJson(data, Cmt.class);
		return qu.addCmt(cmt);
	}
	
	@GetMapping("/load/posts")
	public List<Cmt> loadCmt() throws SQLException{
		return qu.loadListCmtByPostId();
	}
}
