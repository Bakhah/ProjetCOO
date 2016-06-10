/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.ArrayList;
import models.Bucheron;
import models.Etat;
import models.Monde;
import models.Zone;

/**
 *
 * @author Louis
 */
public class Couper extends Action{

    public Couper(Monde mondeDuJeu) {
        super(mondeDuJeu);
        super.nom = "ABATTRE UN ARBRE";
    }

    @Override
    public boolean isPossible(int x, int y) {
        return !this.getZonePossible(x, y).isEmpty();
    }

    @Override
    public ArrayList<Zone> getZonePossible(int x, int y) {
        ArrayList<Zone> list = new ArrayList<>();
        if(super.getMonde().getZone(x, y).getPerso() instanceof Bucheron){
            super.ajoutListSiPossible(list, x, y);
        }
        return list;
    }

    @Override
    public boolean isZonePossible(int x, int y) {
        return super.getMonde().getZone(x,y).getEtat()==Etat.ARBRE;
    }

    @Override
    public void doIt(Zone zoneDepart, Zone zoneArrivee) {
        zoneArrivee.setEtat(Etat.VIDE);
        zoneDepart.getPerso().decrementeNbActions();
    }

    @Override
    public String toStringButton() {
        return "Couper";
    }
    
}
