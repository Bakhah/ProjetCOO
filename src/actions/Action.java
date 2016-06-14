package actions;

import java.util.ArrayList;
import java.util.Random;
import models.Monde;
import models.Zone;

/**
 *
 * @author lalleaul
 */
public abstract class Action {

    protected Monde m;
    protected String nom;
    /**
     * Créer une action
     * @param mondeDuJeu 
     */
    public Action(Monde mondeDuJeu) {
        this.m = mondeDuJeu;
    }

    protected Monde getMonde() {
        return this.m;
    }

    /**
     * L'action est-elle possible DEPUIS la zone
     *
     * @param x abscisses
     * @param y ordonnées
     * @return boolean
     */
    public abstract boolean isPossible(int x, int y);
    /**
     * renvoie la liste des zones vers lesquelles l'action est possible
     * @param x
     * @param y
     * @return 
     */
    public abstract ArrayList<Zone> getZonePossible(int x, int y);
    /**
     * verifie si l'action est possible vers cette zone
     * @param x
     * @param y
     * @return 
     */
    public abstract boolean isZonePossible(int x, int y);
    
    /**
     * execute l'action
     * @param zoneDepart
     * @param zoneArrivee 
     */
    public abstract void doIt(Zone zoneDepart, Zone zoneArrivee);

    public abstract String toStringButton();

    public String toString() {
        return this.nom;
    }
    /**
     * renvoie une action aleatoire possible depuis ces coordonnées
     * @param x
     * @param y
     * @return 
     */
    public Zone getRandomZonePossible(int x, int y) {
        Random r = new Random();
        ArrayList<Zone> list = this.getZonePossible(x, y);
        Zone z = list.get(r.nextInt(list.size()));
        return z;
    }
    
    public void ajoutListSiPossible(ArrayList<Zone> list, int x, int y) {
        //NORD
        if (this.isZonePossible(x, y - 1)) {
            list.add(this.getMonde().getZone(x, y - 1));
        }
        //SUD
        if (this.isZonePossible(x, y + 1)) {
            list.add(this.getMonde().getZone(x, y + 1));
        }
        //OUEST
        if (this.isZonePossible(x - 1, y)) {
            list.add(this.getMonde().getZone(x - 1, y));
        }
        //EST
        if (this.isZonePossible(x + 1, y)) {
            list.add(this.getMonde().getZone(x + 1, y));
        }
    }

}
