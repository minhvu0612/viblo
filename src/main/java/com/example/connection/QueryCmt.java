package com.example.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.model.Cmt;
import com.example.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class QueryCmt {
	
	public connectDB connect = new connectDB();
	public Connection con = null;
	public PreparedStatement pst = null;
	public ResultSet result = null;
	Date date = new Date();
	QueryUser qu = new QueryUser();
	
	// Thêm một bình luận vào database
	public int addCmt(Cmt cmt) throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return -1;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("insert into comments (user_id, post_id, content, time) values (?, ?, ?, ?)");
			pst.setInt(1, cmt.getUserId());
			pst.setInt(2, cmt.getPostId());
			pst.setString(3, cmt.getContent());
			pst.setTimestamp(4, new Timestamp(date.getTime()));
			if (pst.executeUpdate() == 1) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	// Lấy ra toàn bộ comment
	public List<Cmt> loadListCmtByPostId() throws SQLException {
		con = connect.getConnection();
		if (con == null) {
			return null;
		}
		else {
			pst = (PreparedStatement) con.prepareStatement("select * from comments");
			result = pst.executeQuery();
			if (!result.isBeforeFirst()) {
				return null;
			}
			else {
				List<Cmt> list = new ArrayList<Cmt>();
				List<User> li  = qu.getAllUser();
				while (result.next()) {
					Cmt cmt = new Cmt();
					cmt.setUserId(result.getInt("user_id"));
					cmt.setPostId(result.getInt("post_id"));
					cmt.setContent(result.getString("content"));
					cmt.setTime(result.getTimestamp("time"));
					pst = (PreparedStatement) con.prepareStatement("select * from users where id = ?");
					pst.setInt(1, cmt.getUserId());
					for (int i = 0; i < li.size(); i++) {
						if (li.get(i).getId() == cmt.getUserId()) {
							cmt.setAvatar(li.get(i).getAvatar());
							cmt.setUsername(li.get(i).getUsername());
							break;
						}
					}
					list.add(cmt);
				}
				return list;
			}
		}
	}
}
