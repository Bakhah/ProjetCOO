/*
Ajouter ListeActions à une CLASSE ayant accès au monde et à l'équipe qui joue en ce moment
NOTICE :
1. entrer en attribut le monde du jeu et l'équipe qui joue
2. lors du clic sur une zone, appeler :
+ getActionsPossible(int x, int y) : ArrayList<Action>
3. voir Actions pour la suite

 */

package actions;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Coordonnees;
import models.Equipe;
import models.Monde;
import models.Personnage;
import models.Zone;

/**
 *
 * @author lalleaul
 */
public class ListeActions{
    private final ArrayList<Action> listActions;
    private final Equipe e;
    private final Monde m;
    
    public ListeActions(Monde monde, Equipe equipe){
        this.e=equipe;
        this.m=monde;
        this.listActions=new ArrayList<>();
        this.listActions.add(new Deplacement(this.m));
        this.listActions.add(new Creuser(this.m));
        this.listActions.add(new Ramasser(this.m));
        this.listActions.add(new Reboucher(this.m));
        this.listActions.add(new Fouiller(this.m));
        this.listActions.add(new Couper(this.m));
    }
    /**
     * Retourne une liste d'action possible depuis la zone aux coordonnées x:y
     * Retourne une liste vide si aucune action est possible
     * Gère l'absence d'un perso, un perso adverse et un perso qui a déjà joué
     * @param x abscisses
     * @param y ordonnées
     * @return ArrayList<Action>
     */
    public ArrayList<Action> getActionsPossible(int x, int y){
        ArrayList<Action> list = new ArrayList<>();
        //s'il y a un personnage de mon equipe qui n'a pas encore jouer
        // Si la case contient un personnage...
        
        
        if(this.m.getZone(x, y).contientPerso()) {
            Personnage p = this.m.getZone(x, y).getPerso();
            //Si ce personnage est de mon équipe...
            if(p.getCouleur()==this.e.getCouleur()){
                //Si le personnage n'a pas encore joué
                if(p.peutEncoreJouer()){
                    // Pour chaque action, si elle est possible, l'ajouter à la liste
                    for(Action a : listActions){
                        if(a.isPossible(x, y))
                            list.add(a);
                
                    }
                }
            }
        }
        return list;
    }
    public Monde getMonde()
    {
        return this.m;
    }
    public Action getActionPossibleRandom(int x, int y){
        Action a;
        ArrayList<Action>list=this.getActionsPossible(x, y);
        
        if(list.isEmpty()){
            return null;
        }else{
            Random r = new Random();
            return list.get(r.nextInt(list.size()));
        }
    }
    public void RandomPlayTeam(){
        for(Personnage p : this.e.getListePerso()){
            if(!p.isEnJeu()){
                e.getSanctuaire().setPerso(p);
                int xS =e.getSanctuaire().getCoordonnees().getX();
                int yS =e.getSanctuaire().getCoordonnees().getY();
                Action action = this.getActionPossibleRandom(xS,yS );
                if(action!=null){
                    Zone z = action.getRandomZonePossible(xS,yS);
                    action.doIt(this.m.getZone(xS,yS), z);
                }
            }
        }
        for(int h=0;h<this.m.getHauteur();h++){
            for(int l=0;l<this.m.getLargeur();l++){
                Action a = this.getActionPossibleRandom(l, h);
                if(a!=null){
                    Zone z = a.getRandomZonePossible(l,h);
                    a.doIt(this.m.getZone(l,h), z);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ListeActions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
        
}
