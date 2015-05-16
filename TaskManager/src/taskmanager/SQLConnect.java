/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;
import java.sql.*;
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
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        return null;
        }
    }
}
