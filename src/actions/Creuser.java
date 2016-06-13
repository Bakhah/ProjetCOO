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
        super.nom = "DEBLAYER / CREUSER";
    }

    @Override
    /**
     * Vérifie
     */
    public boolean isPossible(int x, int y) {
       //return super.getMonde().getZone(x, y).getPerso() instanceof Piegeur && 
       return !this.getZonePossible(x,y).isEmpty();
    }

    @Override
    public ArrayList<Zone> getZonePossible(int x, int y) {
        ArrayList<Zone> list = new ArrayList<>();
        if(super.getMonde().getZone(x, y).getPerso() instanceof Piegeur){
            super.ajoutListSiPossible(list, x, y);
        }
        return list;
    }

    @Override
    public boolean isZonePossible(int x, int y) {
        return super.getMonde().getZone(x, y).getEtat()==Etat.VIDE ||super.getMonde().getZone(x, y).getEtat()==Etat.TAS;
    }
    
    public void doIt(Zone depart, Zone arrivee){
        if (arrivee.getEtat()==Etat.VIDE){
            arrivee.setEtat(Etat.TROU);
            if(arrivee.contientItem()){
                depart.getPerso().getEquipe().ajouterItem(arrivee.getItem());
                
                depart.setItem(null);
            }
        }
        else if(arrivee.getEtat()==Etat.TAS) arrivee.setEtat(Etat.VIDE);
        depart.getPerso().decrementeNbActions();
    }
    @Override
    public String toStringButton()
    {
        return "Creuser";
    }
}
