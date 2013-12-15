package it.crevu.landing.servlet;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import com.mysql.jdbc.Driver;

public class DBAccess {

	Connection connection;
	String url="jdbc:mysql://localhost:3306/";//deafult url

	String name="crevu";
	String user, password;


		public DBAccess(String url, String name){
			if(url!=null) {
				this.url=url;
				this.name=name;
			}
			ConnectToMysql();
		}
		
		//COSTRUTTORE AVANZATO, Con utente e password inclusi
		public DBAccess(String url, String name, String user, String password) {
			// TODO Auto-generated constructor stub
			this.url=url;
			this.name=name;
			this.user=user;
			this.password=password;
			ConnectToMysql();//POI FAR PRENDERE USER E pw BENE DALLA CONNECT
		}


		public Connection ConnectToMysql(){
			try {
				//Class.forName("org.postgresql.Driver");
				Class driverClass= Class.forName("com.mysql.jdbc.Driver");
				Driver driverInstance= (Driver) driverClass.newInstance();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Classnotfound");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				connection= DriverManager.getConnection(url+name,user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connection failed");
				
			}
			System.out.println("All Right!!");
			
			return connection;
		}

}
