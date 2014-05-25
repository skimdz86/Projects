package it.mdz.todolist.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

	public static Properties loadAppProperties(){
		Properties prop = new Properties();
		InputStream in = PropertiesManager.class.getResourceAsStream("/it/mdz/todolist/resources/application.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			prop = null;
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return prop;
	}
}
