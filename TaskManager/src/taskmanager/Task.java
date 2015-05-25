/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

import java.sql.SQLException;

/**
 *
 * @author scott
 */
public class Task {
    private final String taskToDo; // The is the string of the task that needs doing
    private final int reference; // This is the unique database reference number associated with a given task. 
    
    //Task constructor
    //Creates a new Task object based on a string and a unique database reference number
    public Task(String task,int ref) throws TaskException
    {
        //Ensure the unique reference number is valid. SQLite can have larger
        //unique numbers than Java integers can be, so we have added an exection if this
        //check fails. 
        taskToDo = task;
        if (ref <= 2147483647 && ref > 0)
        {
            reference = ref;
        }
        else
        {
            throw new TaskException();
        }
    }
    
    //Task copy-constructor. Takes a given Task object and creates a copy of it. 
    public Task (Task to_add) throws TaskException
    {
        taskToDo = to_add.taskToDo;
     
        //Ensures the unique database reference number doesn't overflow
        if (to_add.reference <= 2147483647 && to_add.reference > 0)
        {    
            reference = to_add.reference;
        }
        else
            throw new TaskException();
    }

    //Public getter for the unique database reference number. 
    public int getReference()
    {
        return reference;
    }
    
    @Override
    //Creates a toString() method that will return the text of the task String
    //Used by JList when displaying objects. 
    public String toString()
    {
        return taskToDo;
    }

    //The exection thrown if the unique database number isn't valid. 
    public static class TaskException extends Exception {
        String exception;
        public TaskException() {
            exception = "Error: Reference number must be greater than 0 and less than 2147483648";
        }
        
   
        @Override
        public String toString()
        {
            return exception;
        }
    }
}
