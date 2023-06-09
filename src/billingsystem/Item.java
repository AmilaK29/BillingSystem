/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem;

/**
 *
 * @author Amila Kasun
 */
public class Item {
    
    private String code;
    private String name;
    private boolean isQuantity;
    private double unitPrice;
    
    public void setName(String code,String name,boolean isQunatity,double unitPrice){
        
        this.code = code;
        this.name = name;
        this.isQuantity = isQunatity;
        this.unitPrice = unitPrice;
        
    }
    
    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }
    
    public boolean getIsQuantity(){
        return isQuantity;
    }
    
    public double getUnitPrice(){
        return unitPrice;
    }
    
    public Object getPrice(float amount){
        return (amount * unitPrice);
    }
    
    public Object getPrice(int amount){
        return (amount * unitPrice);
    }
    
}
