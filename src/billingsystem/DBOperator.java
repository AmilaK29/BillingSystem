/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public int cardPayment(String card_no,String holders_name,String ex_date,int cvv_cdd,double amount){
        
        int result = 0;
        try {
            String query = "INSERT INTO card_payment(card_no,holders_name,ex_date,cvv_cdd,amount) VALUES (?,?,?,?,?)";     
            pst = conn.prepareStatement(query);
            pst.setString(1,card_no);
            pst.setString(2, holders_name);
            pst.setString(3, ex_date);
            pst.setInt(4, cvv_cdd);
            pst.setDouble(5, amount);
            
            result = pst.executeUpdate();
            
            System.out.println(result);
            
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return result;
        
    }
    
    public int cashPayment(String customer_name,String date,double amount,double amount_paid,double balance){
        
        int rowsInserted = 0;
        
        try {
            String query = "INSERT INTO cash_payment(customer_name,date,amount,amount_paid,balance) VALUES (?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, customer_name);
            pst.setString(2, date);
            pst.setDouble(3, amount);
            pst.setDouble(4, amount_paid);
            pst.setDouble(5, balance);

            rowsInserted = pst.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return rowsInserted;
              
    }
    
    
}
