/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

/**
 *
 * @author scott
 */
public class Task {
    private String taskToDo;
    private int reference;
    
    public Task(String task,int ref)
    {
        taskToDo = task;
        reference = ref;
    }
    
    public Task (Task to_add)
    {
        taskToDo = to_add.taskToDo;
        reference = to_add.reference;
    }

    public int getReference()
    {
        return reference;
    }
    
    public String toString()
    {
        return taskToDo;
    }
}
