package models;

import actions.Action;
import actions.Creuser;
import actions.Deplacement;
import actions.ListeActions;
import actions.Reboucher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TestPushLouis {
    public static void main(String [] args){
        Monde m = new Monde(10,10);


        /*for(Coordonnees c : m.getZonesAccessiblesDepuis(new Coordonnees(1, 1))){
            System.out.println(c);
        }*/
        Equipe e = new Equipe(Couleur.BLEU);
        m.getZone(3, 3).setEtat(Etat.TROU);
        m.getZone(3, 4).setEtat(Etat.VIDE);
        Personnage p = new Topographe(e);
        m.getZone(3, 3).setPerso(p);
        Action a = new Deplacement(m);
        //System.out.println(m.getZone(3, 3).contientPerso());
        //m.getZone(3, 3).setPerso(m.getZone(3, 3).getPerso());
        //a.doIt(m.getZone(new Coordonnees(3,3)), m.getZone(new Coordonnees(3,4)));
        /*ListeActions lA = new ListeActions(m, e);
        for(Action a : lA.getActionsPossible(3, 3)){
            System.out.println(a);
            }
        
        Action a = new Creuser(m);
        System.out.println(a.isPossible(3, 3));*/
    }
}
