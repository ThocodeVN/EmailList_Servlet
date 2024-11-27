/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import Database.CD;
import java.io.Serializable;
/**
 *
 * @author Duy Thanh
 */
public class LineCD extends CD implements Serializable{
    
    private int number;
    private double amount;
    
    public LineCD ()
    {
        number = 0;
        amount = 0;
    }   
    
    public LineCD (int number)
    {
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
