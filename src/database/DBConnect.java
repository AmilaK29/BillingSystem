/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Amila Kasun
 */
public class DBConnect {
    public static Connection connection(){
        
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); //This is used to dynamically load a class at run time
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","amila123");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
        
    }
    
}
