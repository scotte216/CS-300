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
public class UserTest {
    
    public UserTest() {
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
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName test...");
        assertTrue("".equals(new User("","").getName()));
        assertTrue("scott".equals(new User("scott","").getName()));
        assertTrue("a".equals(new User("a","").getName()));
        assertTrue("UPPERCASE".equals(new User("UPPERCASE","").getName()));
        assertTrue("MixedCase".equals(new User("MixedCase","").getName()));
        
        assertFalse("UPPERCASE".equals(new User("uppercase","").getName()));
        assertFalse("lowercase".equals(new User("LOWERCASE","").getName()));
        assertFalse("scott".equals(new User("scoot","").getName()));
        assertFalse("".equals(new User("scott","").getName()));
        assertFalse("".equals(new User(" ","").getName()));
        assertFalse(" ".equals(new User("","").getName()));
        
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName test...");
        User instance = new User("scott","");

        instance.setName("");
        assertTrue("".equals(instance.getName()));
        assertFalse(" ".equals(instance.getName()));
        
        instance.setName("scott");
        assertTrue("scott".equals(instance.getName()));
        
        instance.setName("SCOTT");
        assertTrue("SCOTT".equals(instance.getName()));
        assertFalse("scott".equals(instance.getName()));
        
        instance.setName("scott");
        assertTrue("scott".equals(instance.getName()));
        assertFalse("SCOTT".equals(instance.getName()));
        
        instance.setName(" ");
        assertTrue(" ".equals(instance.getName()));
        assertFalse("".equals(instance.getName()));
        
        instance.setName(null);
        assertEquals(null, instance.getName());
        assertFalse("".equals(instance.getName()));

        instance.setName("MiXeD");
        assertTrue("MiXeD".equals(instance.getName()));
        assertFalse("mixed".equals(instance.getName()));
        assertFalse("MIXED".equals(instance.getName()));
    }

    /**
     * Test of isGood method, of class User.
     */
    @Test
    public void testIsGood() {
        System.out.println("isGood...");
        
        assertTrue(new User("name","password").isGood(new User("name","password")));
        
        assertTrue(new User("scott","password").isGood(new User("scott","password")));
        assertFalse(new User("scott","password").isGood(new User("dan","password")));
        assertFalse(new User("scott","password").isGood(new User("scott","pasword")));
        
        assertTrue(new User("name","1234").isGood(new User("name","1234")));
        assertFalse(new User("name","1234").isGood(new User("name1","1234")));
        assertFalse(new User("name","1234").isGood(new User("name","1235")));
        
        assertTrue(new User("name","UPPERCASE").isGood(new User("name","UPPERCASE")));
        assertFalse(new User("name","UPPERCASE").isGood(new User("same","UPPERCASE")));
        assertFalse(new User("name","UPPERCASE").isGood(new User("name","uppercase")));
        
        assertTrue(new User("name","MiXeD").isGood(new User("name","MiXeD")));
        assertFalse(new User("name","MiXeD").isGood(new User("hoang","MiXeD")));
        assertFalse(new User("name","MiXeD").isGood(new User("name","mixed")));
        assertFalse(new User("name","MiXeD").isGood(new User("name","MIXED")));


        
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword...");

        User instance = new User("name","password");
        
        assertTrue(instance.isGood(new User("name","password")));
        
        instance.setPassword("abcd");
        assertFalse(instance.isGood(new User("name","password")));
        assertFalse(instance.isGood(new User("name","ABCD")));
        assertTrue(instance.isGood(new User("name","abcd")));
        
        instance.setPassword("");
        assertFalse(instance.isGood(new User("name","abcd")));
        assertFalse(instance.isGood(new User("name"," ")));
        assertTrue(instance.isGood(new User("name","")));

        instance.setPassword(" ");
        assertFalse(instance.isGood(new User("name","")));
        assertTrue(instance.isGood(new User("name"," ")));
 
        instance.setPassword("UPPER");
        assertFalse(instance.isGood(new User("name"," ")));
        assertFalse(instance.isGood(new User("name","upper")));
        assertTrue(instance.isGood(new User("name","UPPER")));
 
        instance.setPassword("MiXeD");
        assertFalse(instance.isGood(new User("name","MIXED")));
        assertFalse(instance.isGood(new User("name","mixed")));
        assertTrue(instance.isGood(new User("name","MiXeD")));    }
    
}
