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
 * @author Louis
 */
public class Ramasser extends Action{

    public Ramasser(Monde mondeDuJeu) {
        super(mondeDuJeu);
        super.nom = "RAMASSER UN OBJET";
    }

    @Override
    public boolean isPossible(int x, int y) {
        return super.getMonde().getZone(x, y).contientPerso() && this.isZonePossible(x, y);
    }

    @Override
    public ArrayList<Zone> getZonePossible(int x, int y) {
        ArrayList<Zone>list=new ArrayList<>();
        if(this.isZonePossible(x, y)) list.add(super.getMonde().getZone(x, y));
        return list;
    }

    @Override
    public boolean isZonePossible(int x, int y) {
        if(super.getMonde().getZone(x, y).contientItem()){
            return super.getMonde().getZone(x, y).getItem().estVisible();
        }
        return false;
    }
    public void doIt(Zone zoneDepart, Zone Arrivee){
        Arrivee.getPerso().getEquipe().ajouterItem(Arrivee.getItem());
        Arrivee.setItem(null);
    }
    public String toStringButton()
    {
        return "Ramasser";
    }
}
