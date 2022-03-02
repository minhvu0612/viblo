package com.example.connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class connectDB {
public Connection connect = null;
	
	public Connection getConnection() throws SQLException {
		
		String url  = "jdbc:mysql://localhost:3306/viblo?useSSL=false";
		String user = "root";
		String pass = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = (Connection) DriverManager.getConnection(url,user,pass);
			//System.out.println("Successfully!");
		}
		catch (ClassNotFoundException e){
			System.out.println("Error! Can't connect to database!");
		}
		return connect;
	}
}