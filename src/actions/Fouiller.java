/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.ArrayList;
import models.Monde;
import models.Parcelle;
import models.Zone;

/**
 *
 * @author Louis
 */
public class Fouiller extends Action{

    public Fouiller(Monde mondeDuJeu) {
        super(mondeDuJeu);
        super.nom = "FOUILLER";
    }

    @Override
    public boolean isPossible(int x, int y) {
        return this.isZonePossible(x, y);
    }

    @Override
    public ArrayList<Zone> getZonePossible(int x, int y) {
        ArrayList<Zone> list = new ArrayList<>();
        if(this.isZonePossible(x, y)) list.add(super.getMonde().getZone(x, y));
        return list;
    }

    @Override
    public boolean isZonePossible(int x, int y) {
        return super.getMonde().getZone(x, y) instanceof Parcelle;
    }

    @Override
    public void doIt(Zone zoneDepart, Zone zoneArrivee) {
        if(zoneArrivee.contientItem())zoneArrivee.getItem().setVisible(true);
    }
    @Override
    public String toStringButton() {
        return "Fouiller";
    }
    
}
