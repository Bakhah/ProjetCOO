/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Louis
 */
public class Pathfinder{
    private LinkedList<Coordonnees> list;
    
    public Pathfinder(){
        this.list=new LinkedList<>();
    }
    public Pathfinder(ArrayList<Coordonnees> list){
        this();
        this.list.addAll(list);
    }
    public ArrayList<Coordonnees> theWayFromTo(Coordonnees depart, Coordonnees arrivee){
        ArrayList<Coordonnees>
    }
}
