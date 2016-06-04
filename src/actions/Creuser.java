/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.ArrayList;
import models.Etat;
import models.Monde;
import models.Piegeur;
import models.Zone;

/**
 *
 * @author Louis
 */
public class Creuser extends Action{

    public Creuser(Monde mondeDuJeu) {
        super(mondeDuJeu);
    }

    @Override
    /**
     * Vérifie
     */
    public boolean isPossible(int x, int y) {
       //return super.getMonde().getZone(x, y).getPerso() instanceof Piegeur && 
       return this.getZonePossible(x,y).isEmpty();
    }

    @Override
    public ArrayList<Zone> getZonePossible(int x, int y) {
        ArrayList<Zone>list = new ArrayList<>();
        if(super.getMonde().getZone(x, y).getPerso() instanceof Piegeur){
            super.ajoutListSiPossible(list, x, y);
        }
        return list;
    }

    @Override
    public boolean isZonePossible(int x, int y) {
        return super.getMonde().getZone(x, y).getEtat()==Etat.VIDE ||super.getMonde().getZone(x, y).getEtat()==Etat.TROU;
    }
    
    public void doIt(Zone zoneDepart, Zone Arrivee){
        if (Arrivee.getEtat()==Etat.VIDE){
            Arrivee.setEtat(Etat.TROU);
        }
        else if(Arrivee.getEtat()==Etat.TAS) Arrivee.setEtat(Etat.VIDE);
    }

  
    
}
