/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;


/**
 *
 * @author scott ewing
 */
public class TaskManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ToDo mainscreen = new ToDo();
        mainscreen.show(true);
        
        SQLConnect mySQL = new SQLConnect();
        mySQL.ConnectDB();
        
       
        
    }
    
}
