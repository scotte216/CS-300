/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Scott
 */
public class LogInHandlerTest {
    
    public LogInHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of logIn method, of class LogInHandler.
     * As written there are 4 valid usernames/password pairs. 
     * name: scott
     * password: 1234
     * 
     * name: sally
     * password: 4321
     * 
     * name: mark
     * password: 6666
     * 
     * name: libbey
     * password: password
     * 
     * These are case-sensitive. 
     */
    @Test
    public void testLogIn() {
        System.out.println("Testing the LogIn Handler");
        LogInHandler instance = new LogInHandler();
        
        assertTrue(instance.logIn(new User("scott","1234")));
        assertFalse(instance.logIn(new User("scott ","1234")));
        assertFalse(instance.logIn(new User("scott","123")));
        assertFalse(instance.logIn(new User("SCOTT","1234")));
        assertFalse(instance.logIn(new User("scott","onetwothreefour")));
        assertFalse(instance.logIn(new User(" scott","1234")));
        assertFalse(instance.logIn(new User("Scott","1234")));
        
        assertTrue(instance.logIn(new User("sally","4321")));
        assertFalse(instance.logIn(new User("sally","1234")));
        assertFalse(instance.logIn(new User("sally ","4321")));
        assertFalse(instance.logIn(new User(" sally","4321")));
        assertFalse(instance.logIn(new User("SALLY","4321")));
        assertFalse(instance.logIn(new User("Sally","4321")));
        
        assertTrue(instance.logIn(new User("mark","6666")));
        assertFalse(instance.logIn(new User(" mark","6666")));
        assertFalse(instance.logIn(new User("mark ","6666")));
        assertFalse(instance.logIn(new User("mark","666")));
        assertFalse(instance.logIn(new User("Mark","6666")));
        assertFalse(instance.logIn(new User("MARK","6666")));
        assertFalse(instance.logIn(new User("mark","66666")));
        
        assertTrue(instance.logIn(new User("libbey","password")));
        assertFalse(instance.logIn(new User(" libbey","password")));
        assertFalse(instance.logIn(new User("libbey ","password")));
        assertFalse(instance.logIn(new User("Libbey","password")));
        assertFalse(instance.logIn(new User("LIBBEY","password")));
        assertFalse(instance.logIn(new User("libbey","Password")));
        assertFalse(instance.logIn(new User("libbey","passWord")));
        assertFalse(instance.logIn(new User("libbey","PASSWORD")));
        

        assertFalse(instance.logIn(new User("","")));
        assertFalse(instance.logIn(new User(" "," ")));
        assertFalse(instance.logIn(new User("john","1234")));
        assertFalse(instance.logIn(new User("name","password")));
        assertFalse(instance.logIn(new User("frank","aldfkjs234")));
    }
    
}
