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
public class LogInHandler {
    User [] users;
    
    public LogInHandler()
    {
        users = new User[4];
        users[0] = new User("scott","1234");
        users[1] = new User("sally","4321");
        users[2] = new User("mark","6666");
        users[3] = new User("mary","password");
                
    }
    
    public Boolean logIn(User to_check)
    {
        Boolean result = false;
        
        for (int i = 0; i < 4 && result == false; ++i)
        {
            result = users[i].isGood(to_check);
        }
        return result;
    }
    
}
