/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Amila Kasun
 */
public class DBOperator {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public DBOperator(){
        conn = DBConnect.connection();
    }
    
    public ArrayList<Object> getItem(String codeIn){
        
        ArrayList<Object> itemInfo = new ArrayList<Object>();
        String code = null,name = null;
        boolean isQty = false;
        double unitPrice = 0.0;
        
        try {
            String query = "SELECT * FROM item WHERE code = '"+codeIn+"'";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                code = rs.getString("code");
                name = rs.getString("name");
                if(rs.getInt("qty") == 1){
                    isQty = true;
                }
                else{
                    isQty = false;
                }
            
                unitPrice = rs.getDouble("unit_price");
            }
            
            
            
            itemInfo.add(code);
            itemInfo.add(name);
            itemInfo.add(unitPrice);
            
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        
        return itemInfo;
            
    }
    
    public void cardPayment(String card_no,String holders_name,String ex_date,int cvv_cdd,double amount){
        
        try {
            String query = "INSERT INTO card_payment(card_no,holders_namme,ex_date,cvv_cdd,amount) VALUES"
                    + "('"+card_no+"','"+holders_name+"','"+ex_date+"','"+cvv_cdd+"','"+amount+"')";
            
            pst = conn.prepareStatement(query);
            pst.execute();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
    }
    
}
