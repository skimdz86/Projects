package it.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BaseTest {

	public ApplicationContext ctx = null;
	
	public BaseTest() {
		// TODO Auto-generated constructor stub
		//inizializzo app context
//		ctx = new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("it/test/applicationContext_test.xml");
	}

}
