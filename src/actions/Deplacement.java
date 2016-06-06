/**
 * Instanciez un objet déplacement pour une partie
 * 1. isPossible(int x, int y) : boolean vérifie que l'action est possible depuis cette zone
 * 2. getZoneDeplacementPossible(int x, int y) : ArrayList<Zone> 
 * Recuperer la liste des deplacement possible pour une zone (renvoie une liste vide s'il n'y à pas de choix ou de personnage)
 * 3. Vérifier que le choix du joueur correspond à une zone de la liste
 * 4. deplacePersonnage(Zone zoneDepart, Zone zoneArrivee) : boolean 
 * Déplacer le personnage
 * 
 */
package actions;

import java.util.ArrayList;
import models.Monde;
import models.Renifleur;
import models.TypeDeplacement;
import models.Zone;

/**
 *
 * @author Louis
 */
public class Deplacement extends Action{

    public Deplacement(Monde mondeDuJeu) {
        super(mondeDuJeu);
        super.nom = "DEPLACER UN PERSONNAGE";
    }
    /**
     * Test si la zone existe et si la zone peut accueillir un personnage
     * @param x abscisses
     * @param y ordonnées
     * @return boolean
     */
    @Override
    public boolean isZonePossible(int x, int y){
        return super.getMonde().zoneExist(x, y) && super.getMonde().getZone(x, y).peutAccueillirPerso();
    }
    @Override
    public ArrayList<Zone> getZonePossible(int x, int y){
        ArrayList<Zone> list = new ArrayList<>();
        if(super.getMonde().getZone(x, y).contientPerso()){
            //NORD SUD EST OUEST
            super.ajoutListSiPossible(list, x,y);
            //Si le personnage est un TOPOGRAPHE, on ajoute à la liste...
            if(super.getMonde().getZone(x, y).getPerso().getTypeDep()==TypeDeplacement.DIAGONALE){
                // NORD-OUEST
                if(this.isZonePossible(x-1, y-1)) list.add(super.getMonde().getZone(x-1, y-1));
                // NORD-EST
                if(this.isZonePossible(x+1, y-1)) list.add(super.getMonde().getZone(x+1, y-1));
                //SUD-OUEST
                if(this.isZonePossible(x-1, y+1)) list.add(super.getMonde().getZone(x-1, y+1));
                //SUD-EST
                if(this.isZonePossible(x+1, y+1)) list.add(super.getMonde().getZone(x+1, y+1));
            }
        }
        return list;
    }
    /**
     * Deplace le personnage de la zone de départ à la zone d'arrivée
     * @param zoneDepart
     * @param zoneArrivee
     */
    @Override
    public void doIt(Zone zoneDepart, Zone zoneArrivee){
        if(zoneArrivee.setPerso(zoneDepart.getPerso())){
            zoneDepart.setPerso(null);
            //Si c'est une renifleur qu'on déplace et qu'il y a un objet dans la zone...
            if(zoneArrivee.getPerso() instanceof Renifleur && zoneArrivee.getItem()!= null){
                //L'objet devient visible
                zoneArrivee.getItem().setVisible(true);
            }
        }
    }

    @Override
    public boolean isPossible(int x, int y) {
        return this.getZonePossible(x,y).isEmpty();
    }
}
