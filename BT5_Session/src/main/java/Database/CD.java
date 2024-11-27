/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Duy Thanh
 */

import java.io.Serializable;

public class CD implements Serializable {
    protected String name;
    protected double price;

    public CD ()
    {
        name = "";
        price = 0;
    }
     
    public CD (String name, double price){
        this.name = name;
        this.price = price;
    }
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
