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
public class Reboucher extends Action{

    public Reboucher(Monde mondeDuJeu) {
        super(mondeDuJeu);
        super.nom = "REBOUCHER / ENTASSER";
    }

    @Override
    public boolean isPossible(int x, int y) {
        return !this.getZonePossible(x, y).isEmpty();
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
        Etat e = super.getMonde().getZone(x, y).getEtat();
        return e==Etat.TROU ||e==Etat.VIDE;
    }

    @Override
    public void doIt(Zone zoneDepart, Zone zoneArrivee) {
        Etat e = zoneArrivee.getEtat();
        if(e==Etat.TROU)zoneArrivee.setEtat(Etat.VIDE);
        else if (e==Etat.VIDE)zoneArrivee.setEtat(Etat.TAS);
        zoneDepart.getPerso().decrementeNbActions();
    }
    public String toStringButton()
    {
        return "Poser un tas";
    }
    
}
