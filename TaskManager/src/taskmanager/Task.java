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
    private int taskType; //0 to-do, 1-in progress, 2-done
    
    public Task ()
    {
        taskToDo = new String();
        taskType = 0;
        
    }
    
    public Task (String to_add)
    {
        taskToDo = to_add;
        taskType = 0;
    }
    
    public Task (Task to_add)
    {
        taskToDo = to_add.taskToDo;
        taskType = to_add.taskType;
    }
    
    public boolean setType(int new_type)
    {
        if (new_type >= 0 && new_type <= 2)
        {
            taskType = new_type;
            return true;
        }
        return false;
    }
    
    public int getType()
    {
        return taskType;
    }
}
