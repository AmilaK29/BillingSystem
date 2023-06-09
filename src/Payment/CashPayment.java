/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import billingsystem.DBOperator;
import billingsystem.cashPaymentWin;
import javax.swing.JFrame;

/**
 *
 * @author Amila Kasun
 */
public class CashPayment extends PaymetSystem{

   
    String customer_name;
    String date;
    double amount_paid;
    double balance;
    int result = 0;
   
    
    @Override
    public int processOfPayment(double amount) {
        //Code to procceed the payment using the cash method
        DBOperator dbo = new DBOperator();
        this.result = dbo.cashPayment(customer_name, date, amount,amount_paid,balance);
        
        return result;
        
    }

    @Override
    public void Display(double amount) {
        //Display the cash payment window
        cashPaymentWin cpw = new cashPaymentWin();
        cpw.setAmountForButton(amount);
        cpw.setVisible(true);
        
    }
    
    public void setValues(String name,String date,double paid_amount,double balance){
        this.customer_name = name;
        this.date = date;
        this.amount_paid = paid_amount;
        this.balance = balance;
        
    }
    
}
