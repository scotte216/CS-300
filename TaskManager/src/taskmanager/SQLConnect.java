/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 * This is the object used to interact with the SQLite database
 * The database is expected to be in the root directory named TaskManagerDB.sqlite
 * The table is called: TASKS
 * It will have 4 columns: REFERENCE, NAME, TASK, TASKTYPE
 * Reference: is a unique DB integer.
 * Name: a string name -- must match login name
 * Task: A string task -- ex: "Go to the store" 
 * Tasktype: 0 = to do; 1 = in progress; 2 = done
 * 
 * @author scott
 */
public class SQLConnect {
    private Connection conn;
    private final static String DB_driver = "org.sqlite.JDBC";
    private final static String DB_path = "jdbc:sqlite:TaskManagerDB.sqlite";
    
    //Default constructor
    public SQLConnect()
    {
        conn = null;
    }
    
    //ConnectDB will open a connection to this database and return that connection
    private Connection ConnectDB(){
        try{
            Class.forName(DB_driver);
            conn = DriverManager.getConnection(DB_path);
            return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
    
    //Returns the ResultSet for a given name and task type from the database
    //0 = to do
    //1 = in progress
    //2 = done
    // Note: this method doesn't use prepared statements since it is only used internally.
    public ResultSet getResults(String name,int task_type)
    {
        //Error checking for task_type being a valid number. 
        if (task_type < 0 || task_type > 2)
        {
            System.out.println("Error in SQLConnect.java.getResults() -- task_type must be 0, 1, or 2");
            return null;
        }
        
        try {
            //creates a connection and statement and query to get the result set
            Connection con = this.ConnectDB();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM TASKS WHERE NAME = '"+name+"' AND TASKTYPE = '"+task_type+"'";
            
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //Adds a new string to the database based on parameter 'name' and the new string of text to do. 
    //Tasktype will = 0 as a new task. 
    public void add(String name, String newToDo)
    {
        if (newToDo == null || name == null || newToDo.length() == 0 || name.length() == 0 )
            return;
        try {
            //Open a connection and create a statement and query.
            Connection con =  ConnectDB();
            PreparedStatement prepStmt;
            
            //With NULL for an integer unique value, SQLite will automatically pick the next biggest integer for
            //the REFERENCE number
            String query = "INSERT INTO TASKS VALUES(NULL, ?, ?, '0')";
            prepStmt = con.prepareStatement(query);
            
            prepStmt.setString(1,name);
            prepStmt.setString(2, newToDo);
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    /**
     *
     * @param edited_task
     * Update a given Task with this new edited_task Task. It is expected the unique reference number
     * of the task to be updated is inside of edited_task already. The text inside of edited_task will also
     * should be the desired new text. 
     *  
     */
        public void edit(Task edited_task)
    {
        try {
            //open a connection and create a query for the statement. This will only update the TASKS column using
            //the reference number as a way of finding the entry.
            Connection con = ConnectDB();
            PreparedStatement prepStmt;
            
            String query = "UPDATE TASKS SET TASK = ? WHERE REFERENCE = '"+ edited_task.getReference() +"'";
            prepStmt = con.prepareStatement(query);
            
            prepStmt.setString(1, edited_task.toString());
            
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param to_delete the task we want to delete from the database
     * it is assume this Task has the unique reference number of the task to be deleted. 
     */
    public void delete(Task to_delete)
    {
        try {
            Connection con =  ConnectDB();
            Statement stmt = con.createStatement();
            String query = "DELETE FROM TASKS WHERE REFERENCE = '"+to_delete.getReference()+"'";
            
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param to_promote -- The task to be promoted. Uses the unique reference number for the query.
     * @param toTaskType -- Promote the task TO this new value. 
     * 
     * 0 = to do
     * 1 = in progress
     * 2 = done
     */
    public void promote(Task to_promote, int toTaskType)
    {
        //Checks to ensure the toTaskType is a valid number. 
        if (toTaskType < 0 || toTaskType > 2)
        {
            System.out.println("Error in SQLConnect.java.promote() -- toTaskType must be 0, 1 or 2");
            return;
        }
        
        try {
            Connection con =  ConnectDB();
            Statement stmt = con.createStatement();
            String query = "UPDATE TASKS SET TASKTYPE = "+toTaskType+" WHERE REFERENCE = '"+to_promote.getReference()+"'";
            
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
