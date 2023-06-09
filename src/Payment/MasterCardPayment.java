/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import billingsystem.DBOperator;
import billingsystem.MasterPayment;
import javax.swing.JFrame;

/**
 *
 * @author Amila Kasun
 */
public class MasterCardPayment extends PaymetSystem{

    
    String card_no;
    String holders_name;
    String ex_date;
    int cvv_cdd;
    int result = 0;
     
    
    @Override
    public int processOfPayment(double amount) {
        //Code to procceed the payment using the master card method
        DBOperator dbo = new DBOperator();
        result = dbo.cardPayment(card_no, holders_name, ex_date, cvv_cdd, amount);
        
        return result;
    }

    @Override
    public void Display(double amount) {
        MasterPayment masterPayment = new MasterPayment();
        masterPayment.setVisible(true);
        masterPayment.setAmountForButton(amount);
    }
    
    public void setDetails(String card_no,String holders_name,String ex_date,int cvv_cdd){
        this.card_no = card_no;
        this.holders_name = holders_name;
        this.ex_date = ex_date;
        this.cvv_cdd = cvv_cdd;
    }
    
}
