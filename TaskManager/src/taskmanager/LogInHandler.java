/*
 * This class is a stub for checking usernames and passwords. Since login security
 * is outside the scope of this project, this class will replace any robust
 * security measures. 
 */
package taskmanager;

/**
 *
 * @author scott ewing
 */
public class LogInHandler {
    User [] users;
    
    public LogInHandler()
    {
        users = new User[4];
        users[0] = new User("scott","1234");
        users[1] = new User("sally","4321");
        users[2] = new User("mark","6666");
        users[3] = new User("libbey","password");
                
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
