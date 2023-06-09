/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem;

import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Amila Kasun
 */
public class DBconnect {
    
    public static Connection connection(){
        
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","amila123");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
        
    }
    
    
}
