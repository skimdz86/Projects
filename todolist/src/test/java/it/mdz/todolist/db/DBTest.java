package it.mdz.todolist.db;

import it.mdz.todolist.model.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DBTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DBTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DBTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDB()
    {
    	testUser();
    }
    public void testUser(){
    	DataManager dm = new MongoManager();
    	User u = new User();
    	u.setUserid("pipop");
    	u.setPassword("asd1234");
        assertTrue(dm.insertUser(u));
    }
}
