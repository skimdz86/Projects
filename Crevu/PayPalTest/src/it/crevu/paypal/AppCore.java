package it.crevu.paypal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AppCore {

	DBAccess db = null;
	Connection conn = null;
	
	
	public AppCore() {
		super();
		db = new DBAccess("jdbc:mysql://127.2.126.1:3306/", "development", "adminH4USygl", "Va8qN4bqNmUj");
//		db = new DBAccess("jdbc:mysql://crevu-db-1.cexu4efkcbm6.us-east-1.rds.amazonaws.com:3306/", "crevu", "crevu_user", "yell0wPe4c0ck");
//		db = new DBAccess("jdbc:mysql://localhost:3306/", "crevu", "root", "root");
		conn = db.ConnectToMysql();
	}

	public void saveData(String itemName, String itemNumber, String paymentStatus, String paymentAmount, String paymentCurrency, String txnId, String receiverEmail, String payerEmail, String string, String string2) throws SQLException{
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO paypal_data VALUES(?,?,?,?,?,?,?,?,?,?)");
		stmt.setString(1, itemName);
		stmt.setString(2, itemNumber);
		stmt.setString(3, string);
		stmt.setString(4, paymentStatus);
		stmt.setString(5, paymentAmount);
		stmt.setString(6, paymentCurrency);
		stmt.setString(7, txnId);
		stmt.setString(8, receiverEmail);
		stmt.setString(9, payerEmail);
		stmt.setString(10, string2);
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
