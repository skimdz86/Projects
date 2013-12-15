package it.test;

import it.crevu.dao.WelcomeUserDAO;
import it.crevu.db.WelcomeUser;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExampleTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExampleTest test = new ExampleTest();
		test.testFuncion();
		
	}
	
	public void testFuncion(){
		WelcomeUserDAO dao = (WelcomeUserDAO)ctx.getBean("WelcomeUserDAO");
		WelcomeUser input= new WelcomeUser("max","max",new Date());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WelcomeUserFactory");
		EntityManager entityManager= emf.createEntityManager();;
		Collection<String> c;
//		DAOWelcomeUserMethods d = new DAOWelcomeUserMethods();
//		d.setEntityManager(entityManager);
//		c=d.loadWelcomeUserByNickname("marco");
//		System.out.println(Arrays.toString(c.toArray()));
		
		WelcomeUser res = dao.findById(1);
		res.setNickname("marco");
		dao.merge(res);
		System.out.println(res.getEmail());
		

		
	}

}
