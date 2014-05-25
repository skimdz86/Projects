package it.mdz.todolist.db;

import it.mdz.todolist.util.PropertiesManager;

import java.util.Arrays;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoDB {
	
	static Logger logger = LogManager.getLogger(MongoDB.class.getName());
	Properties prop = new Properties();
	DB db = null;
	
	private static MongoDB mongodb = null;
	
	public static MongoDB getInstance(){
		if(mongodb == null){
			mongodb = new MongoDB();
		}
		return mongodb;
	}
	
	private MongoDB(){
		prop = PropertiesManager.loadAppProperties();
		connect();
	}

	private void connect(){
		try {
			// To connect to mongodb server
			// Now connect to your databases
			MongoClient mongoClient;
			
			if("yes".equals(prop.getProperty("mongoauth"))){
				char[] password = prop.getProperty("mongopwd").toCharArray();
				MongoCredential credential = MongoCredential.createMongoCRCredential(prop.getProperty("mongouser"), prop.getProperty("mongodbname"), password);
				mongoClient = new MongoClient(new ServerAddress(prop.getProperty("mongohost"), Integer.parseInt(prop.getProperty("mongoport"))), Arrays.asList(credential));
				logger.info("Connecting with authentication");
			}
			else {
				mongoClient = new MongoClient(new ServerAddress(prop.getProperty("mongohost"), Integer.parseInt(prop.getProperty("mongoport"))));
				logger.info("Connecting without authentication");
			}
			
			db = mongoClient.getDB(prop.getProperty("mongodbname"));
			logger.info("Connect to database successfully");
			
		} catch (Exception e) {
			logger.error(e.getClass().getName() + ": " + e.getMessage(), e);
		}
	}
	
	public DB getConnection(){
		return db;
	}

} 

