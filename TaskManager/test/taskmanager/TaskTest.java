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
import taskmanager.Task.TaskException;

/**
 *
 * @author Scott
 */
public class TaskTest {
    
    public TaskTest() {
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


    @Test
    public void testGetReference() throws TaskException {
            System.out.println("getReference");
            
            assertTrue(1 == new Task("Task",1).getReference());
            assertTrue(2 == new Task("Task",2).getReference());
            
            assertTrue(1 == new Task("",1).getReference());
            assertTrue(2 == new Task("",2).getReference());

            assertTrue(2147483646 == new Task("Task",2147483646).getReference());
            assertTrue(2147483647 == new Task("Task",2147483647).getReference()); 
            
            assertFalse(0 == new Task("Task",1).getReference());
            assertFalse(2 == new Task("Task",1).getReference());
            
            assertFalse(1 == new Task("Task",2).getReference());
            assertFalse(3 == new Task("Task",2).getReference());
            
            assertTrue(2147483647 == new Task("Task",2147483647).getReference());
    }
    
     /**
     * The 'reference number' is assigned by SQLite automatically. FROM SQLite
     * documentation: 
     * The usual algorithm is to give the newly created row a ROWID that is one 
     * larger than the largest ROWID in the table prior to the insert. If the 
     * table is initially empty, then a ROWID of 1 is used. If the largest 
     * ROWID is equal to the largest possible integer (9223372036854775807) 
     * then the database engine starts picking positive candidate ROWIDs at 
     * random until it finds one that is not previously used.
     * 
     * NOTE: 9223372036854775807 is too large an integer for Java so Task.java
     * ensures they are no larger than 2147483647. 
     * @throws taskmanager.Task.TaskException
     */
    @Test (expected=TaskException.class)
    public void testGetReferenceLarge() throws TaskException
    {
        int i = 2147483647;
            
        i = i+1;
        Task temp = new Task("task erroneous reference number",i);
    }
    
    @Test (expected=TaskException.class)
    public void testGetReferenceZero() throws TaskException
    {
        Task temp2 = new Task("task with erroneous reference number",0);
    }
    
    @Test (expected=TaskException.class)
    public void testGetReferenceNeg() throws TaskException
    {
        Task temp2 = new Task("task with erroneous reference number",-1);
    }    
    
    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        try {
            System.out.println("toString");
            
            Task instance = new Task("abcd",1);
            
            assertTrue("abcd".equals(instance.toString()));
            assertFalse("ABCD".equals(instance.toString()));
            assertFalse("Abcd".equals(instance.toString()));
            assertFalse("AbCd".equals(instance.toString()));
            assertFalse("abcd ".equals(instance.toString()));
            assertFalse(" abcd".equals(instance.toString()));
            assertFalse("ab cd".equals(instance.toString()));
            assertFalse("ab.cd".equals(instance.toString()));
            
            assertTrue("reference doesn't matter".equals(new Task("reference doesn't matter",1).toString()));
            assertTrue("reference doesn't matter".equals(new Task("reference doesn't matter",2).toString()));
            
            Task instance2 = new Task("Here is a new task to do.",1);
            
            assertTrue("Here is a new task to do.".equals(instance2.toString()));
            assertFalse("here is a new task to do.".equals(instance2.toString()));
            assertFalse("HERE IS A NEW TASK TO DO.".equals(instance2.toString()));
            assertFalse("Hereisanewtasktodo.".equals(instance2.toString()));
            assertFalse("".equals(instance2.toString()));
            
        } catch (Task.TaskException ex) {
            System.out.println(ex);
        }
    }
    
}
