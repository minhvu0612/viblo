package com.example.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class QueryUser {
	public connectDB connect = new connectDB();
	public Connection con = null;
	public PreparedStatement pst = null;
	public ResultSet result = null;
	
	// Thêm 1 user vào database
	public int addUser(User user) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return -1;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("insert into users (username, email, gender, password) values (?, ?, ?, ?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getGender());
			pst.setString(4, user.getPassword());
			if (pst.executeUpdate() == 1) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	
	// Kiếm tra xem user đã tồn tại hay chưa
	public int checkUserExist(String username, String email) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return -1;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from users where username = ? and email = ?");
			pst.setString(1, username);
			pst.setString(2, email);
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return 1;
			}
			else return 0;
		}
	}
	
	// Lấy ra dữ liệu của một người dùng thông qua id
	public User getUserById(int id) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return null;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from users where id = ?");
			pst.setInt(1, id);
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return null;
			}
			else {
				User user = new User();
				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setUsername(result.getString("username"));
					user.setEmail(result.getString("email"));
					user.setGender(result.getString("gender"));
					user.setPassword(result.getString("password"));
					user.setAvatar(result.getString("avatar"));
				}
				return user;
			}
		}
	}
	
	
	// Lấy dữ liệu của một người dùng thông qua username
	public User getUserByUsername(String username) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return null;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from users where username = ?");
			pst.setString(1, username);
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return null;
			}
			else {
				User user = new User();
				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setUsername(result.getString("username"));
					user.setEmail(result.getString("email"));
					user.setGender(result.getString("gender"));
					user.setPassword(result.getString("password"));
					user.setAvatar(result.getString("avatar"));
				}
				return user;
			}
		}
	}
	
	// Lấy dữ liệu của người dùng thông qua username và password
	public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return null;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from users where username = ? and password = ?");
			pst.setString(1, username);
			pst.setString(2, password);
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return null;
			}
			else {
				User user = new User();
				while (result.next()) {
					user.setId(result.getInt("id"));
					user.setUsername(result.getString("username"));
					user.setEmail(result.getString("email"));
					user.setGender(result.getString("gender"));
					user.setPassword(result.getString("password"));
					user.setAvatar(result.getString("avatar"));
				}
				return user;
			}
		}
	}
	
	// Cập nhật user
	public int updateUser(User user) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return -1;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("update users set username = ?, email = ?, gender = ?, avatar = ? where username = ?");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getGender());
			pst.setString(4, user.getAvatar());
			pst.setString(5, user.getUsername());
			if (pst.executeUpdate() == 1) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	// Lấy hết tất cả dữ liệu về user
	public List<User> getAllUser() throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return null;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from users");
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return null;
			}
			else {
				List<User> list = new ArrayList<User>();
				while (result.next()) {
					User u = new User();
					u.setId(result.getInt("id"));
					u.setAvatar(result.getString("avatar"));
					u.setEmail(result.getString("email"));
					u.setGender(result.getString("gender"));
					u.setPassword(result.getString("password"));
					u.setUsername(result.getString("username"));
					list.add(u);
				}
				return list;
			}
		}
	}
}
