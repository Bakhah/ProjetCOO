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
    /**
     * Retourne le premier chemin qu'il trouve d'un point A à B
     * @param depart Coordonnées presentes dans la liste
     * @param arrivee Coordonnées presentes dans la liste
     * @return 
     */
    public ArrayList<Coordonnees> theWayFromTo(Coordonnees depart, Coordonnees arrivee){
        //On déclare une list qui contiendra le chemin ordonné
        ArrayList<Coordonnees> theWay = new ArrayList<>();
        theWay.add(depart);
        list.remove(depart);
        int i=0;
        while(!theWay.contains(arrivee)){
            
        }
        for(i=0;i<theWay.size();i++){
            for(Coordonnees c : list){
                if(c.estCoteACote(theWay.get(i)))theWay.add(c);
            }
        }
        return theWay;
    }
    private boolean ilYAUnVoisinPour(Coordonnees coordonnees){
        for(Coordonnees c : this.list){
            if(c.estCoteACote(coordonnees)) return true;
        }
        return false;
    }
}
