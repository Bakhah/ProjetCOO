package models;

import java.util.ArrayList;

/**
 *
 * @author Louis
 */
public class Partie {
    private final ArrayList<Joueur> joueurs;
    private final Monde monde;
    private ArrayList<Tour> listTours;
    
    public Partie(ArrayList<Joueur> joueurs, Monde monde){
        this.joueurs=new ArrayList<>();
        this.joueurs.addAll(joueurs);
        this.monde=monde;
    }
    
    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public Monde getMonde() {
        return monde;
    }
    
}
