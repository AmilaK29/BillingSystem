/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package billingsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Amila Kasun
 */
public class BillingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection conn = DBconnect.connection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String id = "ka12";
        String name = "amila";
        String country = "India";
        
        BillingUI bui = new BillingUI();
        bui.setVisible(true);
        
        
//        try {
//            String qry = "SELECT * FROM user";
//            pst = conn.prepareStatement(qry);
//            rs = pst.executeQuery();
//            
//            
//            
//            
//            
//        } catch (Exception e) {
//            
//            JOptionPane.showMessageDialog(null, e);
//        }
        
        
        
    }
    
}
