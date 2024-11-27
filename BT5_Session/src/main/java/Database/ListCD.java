/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.ArrayList;

/**
 *
 * @author Duy Thanh
 */
public class ListCD {
    private ArrayList<CD> listCD;
    
    public ListCD ()
    {
        listCD = new ArrayList<CD>();
        listCD.add(new CD("86 (the band) - True Life Songs and Pictures", 14.95));
        listCD.add(new CD("Paddlefoot - The first CD", 12.95));
        listCD.add(new CD("Paddlefoot - The second CD", 14.95));
        listCD.add(new CD("Joe Rut - Genuine Wood Grained Finish", 14.95));      
    }
    
    public ArrayList<CD> getListCD()
    {
        return listCD;
    }
}
