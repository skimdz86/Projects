package it.crevu.landing.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AppCore {

	DBAccess db = null;
	Connection conn = null;
	
	
	public AppCore() {
		super();
//		db = new DBAccess("jdbc:mysql://127.12.109.1:3306/", "crevu", "admin9ciNjkS", "WHmisTVQGYKJ");
		db = new DBAccess("jdbc:mysql://crevu-db-1.cexu4efkcbm6.us-east-1.rds.amazonaws.com:3306/", "crevu", "crevu_user", "yell0wPe4c0ck");
//		db = new DBAccess("jdbc:mysql://localhost:3306/", "crevu", "root", "root");
		conn = db.ConnectToMysql();
	}

	public void saveUser(String nickname, String email, String message) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO WELCOME_USER (NICKNAME, EMAIL, MESSAGE, DATE_CREATE) VALUES(?,?,?,?)");
		stmt.setString(1, nickname);
		stmt.setString(2, email);
		stmt.setString(3, message!=null?message:"");
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		stmt.setDate(4, sqlDate);
		stmt.executeUpdate();
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			conn.close();
			System.out.println("close connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
