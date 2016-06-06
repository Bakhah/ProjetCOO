/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import java.util.ArrayList;
import models.Monde;
import models.Zone;


/**
 *
 * @author lalleaul
 */
public abstract class Action {
    protected Monde m;
    protected String nom;
    public Action (Monde mondeDuJeu){
        this.m = mondeDuJeu;
    }
    protected Monde getMonde(){
        return this.m;
    }
    /**
     * L'action est-elle possible DEPUIS la zone
     * @param x abscisses
     * @param y ordonnées
     * @return boolean
     */
    public abstract boolean isPossible(int x, int y);
    public abstract ArrayList<Zone> getZonePossible(int x, int y);
    public abstract boolean isZonePossible(int x, int y);
    public abstract void doIt(Zone zoneDepart, Zone zoneArrivee);
    public abstract String toStringButton();
    
    public String toString(){
        return this.nom;
    }
    
    public void ajoutListSiPossible(ArrayList<Zone> list, int x, int y){
        //NORD
        if(this.isZonePossible(x, y-1)) list.add(this.getMonde().getZone(x, y-1));
        //SUD
        if(this.isZonePossible(x, y+1)) list.add(this.getMonde().getZone(x, y+1));
        //OUEST
        if(this.isZonePossible(x-1, y)) list.add(this.getMonde().getZone(x-1, y));
        //EST
        if(this.isZonePossible(x+1, y)) list.add(this.getMonde().getZone(x+1, y));
    }

   
    
    
}
