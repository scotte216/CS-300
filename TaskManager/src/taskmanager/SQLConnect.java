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
 *
 * @author scott
 */
public class SQLConnect {
    private Connection conn;
    private final static String DB_driver = "org.sqlite.JDBC";
    private final static String DB_path = "jdbc:sqlite:TaskManagerDB.sqlite";
    
    public SQLConnect()
    {
        conn = null;
    }
    
    public Connection ConnectDB(){
        try{
            Class.forName(DB_driver);
            conn = DriverManager.getConnection(DB_path);
            //JOptionPane.showMessageDialog(null,"Connection established");
            return conn;
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
    
    public ResultSet getResults(String name,int task_type)
    {
        try {
            Connection con = this.ConnectDB();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM TASKS WHERE NAME = '"+name+"' AND TASKTYPE = '"+task_type+"'";
            
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void add(String name, String newToDo)
    {
        try {
            Connection con =  ConnectDB();
            Statement stmt = con.createStatement();
            //With NULL for an integer unique value, it will automatically pick the next biggest integer.
            String query = "INSERT INTO TASKS VALUES(NULL,'"+name+"','"+newToDo+"','0')";
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void edit(Task to_edit)
    {
        try {
            Connection con = ConnectDB();
            Statement stmt = con.createStatement();
            String query =  "UPDATE TASKS SET TASK = '"+to_edit.toString()+"' WHERE REFERENCE  = '"+to_edit.getReference()+"'";
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    
    public void promote(Task to_promote, int toTaskType)
    {
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
