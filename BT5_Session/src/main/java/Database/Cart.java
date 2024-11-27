/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.util.ArrayList;
import Database.LineCD;
/**
 *
 * @author Duy Thanh
 */
public class Cart {
    private ArrayList<LineCD> listLineCD;
    
    public Cart(){
        listLineCD = new ArrayList<LineCD>();
    }
    
    public void addToCart(LineCD line)
    {
        this.listLineCD.add(line);
    }
    
    public LineCD getLineCDByName(String name){
        for (LineCD lineCD : listLineCD){
            if (lineCD.getName().equals(name)){
                return lineCD;
            }
        }
        return null;
    }
    
    public boolean removeFromCart(String name){
         for (LineCD lineCD : listLineCD){
            if (lineCD.getName().equals(name)){
                listLineCD.remove(lineCD);
                return true;
            }
        }
         return false;
    }
    
    public void removeFromCart(int index)
    {
        this.listLineCD.remove(index);
    }
    
    public ArrayList<LineCD> getListLineCD()
    {
        return listLineCD;
    }
    
    public double calculateTotal() {
        double total = 0;
        for (LineCD item : listLineCD) {
            total += item.getAmount();
        }
        return total;
    }

}
