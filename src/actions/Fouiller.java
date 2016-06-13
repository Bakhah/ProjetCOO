/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Item;
import models.Monde;
import models.Parcelle;
import models.Renifleur;
import models.Zone;
import view.ItemFoundDialog;

/**
 *
 * @author Louis
 */
public class Fouiller extends Action {

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
        if (this.isZonePossible(x, y)) {
            list.add(super.getMonde().getZone(x, y));
        }
        return list;
    }

    @Override
    public boolean isZonePossible(int x, int y) {
        return super.getMonde().getZone(x, y) instanceof Parcelle && !super.getMonde().getZone(x, y).isFouillee();
    }

    @Override
    public void doIt(Zone zoneDepart, Zone zoneArrivee) {

        ItemFoundDialog ifd = new ItemFoundDialog(zoneDepart.getPerso(), zoneArrivee);
        zoneDepart.getPerso().decrementeNbActions();
        if (zoneArrivee.contientItem()) {
            zoneArrivee.setItemVisible(true);
        }
        zoneArrivee.setFouillee(true);
    }

    @Override
    public String toStringButton() {
        return "Fouiller";
    }

}
