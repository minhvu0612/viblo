package com.example.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Post;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class QueryPost {
	public connectDB connect = new connectDB();
	public Connection con = null;
	public PreparedStatement pst = null;
	public ResultSet result = null;
	
	public QueryUser queryU = new QueryUser();
	
	
	// Thêm 1 post vào Database
	public int addPost(Post post) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return -1;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("insert into posts (user_id, content, image) values (?, ?, ?)");
			pst.setInt(1, post.getUserId());
			pst.setString(2, post.getContent());
			pst.setString(3, post.getImg());
			if (pst.executeUpdate() == 1) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	// Lấy dữ liệu của toàn bộ post
	public List<Post> loadAllPost() throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return null;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from posts");
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return null;
			}
			else {
				List<Post> list = new ArrayList<Post>();
				while (result.next()) {
					Post p = new Post();
					p.setId(result.getInt("id"));
					p.setUserId(result.getInt("user_id"));
					p.setContent(result.getString("content"));
					p.setImg(result.getString("image"));
					p.setUsername(queryU.getUserById(result.getInt("user_id")).getUsername());
					p.setAvatar(queryU.getUserById(result.getInt("user_id")).getAvatar());
					list.add(p);
				}
				return list;
			}
		}
	}
	
	
	// Search post
		public List<Post> searchPost(String s) throws SQLException {
			con = connect.getConnection();
			if (con == null) {
				return null;
			}
			else {
				pst = (PreparedStatement) con.prepareStatement("select * from posts");
				result = pst.executeQuery();
				if (!result.isBeforeFirst()) {
					return null;
				}
				else {
					List<Post> list = new ArrayList<Post>();
					while (result.next()) {
						Post p = new Post();
						p.setId(result.getInt("id"));
						p.setUserId(result.getInt("user_id"));
						p.setContent(result.getString("content"));
						p.setImg(result.getString("image"));
						p.setUsername(queryU.getUserById(result.getInt("user_id")).getUsername());
						p.setAvatar(queryU.getUserById(result.getInt("user_id")).getAvatar());
						if (p.getContent().contains(s)) {
							list.add(p);
						}
					}
					return list;
				}
			}
		}
	
	// Lấy dữ liệu của post bằng id của người dùng
	public List<Post> loadPostByUserId(int id) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return null;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from posts where user_id = ?");
			pst.setInt(1, id);
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return null;
			}
			else {
				List<Post> list = new ArrayList<Post>();
				while (result.next()) {
					Post p = new Post();
					p.setId(result.getInt("id"));
					p.setUserId(result.getInt("user_id"));
					p.setContent(result.getString("content"));
					p.setImg(result.getString("image"));
					p.setUsername(queryU.getUserById(result.getInt("user_id")).getUsername());
					p.setAvatar(queryU.getUserById(result.getInt("user_id")).getAvatar());
					list.add(p);
				}
				return list;
			}
		}
	}
}
