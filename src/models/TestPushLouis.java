package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TestPushLouis {
    public static void main(String [] args){
        Monde m = new Monde(10,10);
        System.out.println(m);

        for(Coordonnees c : m.getZonesAccessiblesDepuis(new Coordonnees(1, 1))){
            System.out.println(c);
        }
        
       
        
    }
    
}
