package models;

import actions.Action;
import actions.Couper;
import actions.Creuser;
import actions.Deplacement;
import actions.Fouiller;
import actions.ListeActions;
import actions.Ramasser;
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
        System.out.println(m);
        Equipe e = new Equipe(Couleur.BLEU);
        m.getZone(2, 5).setEtat(Etat.VIDE);
        Personnage p = new Bucheron(e);
        p.setItem(Item.GOAL);
        m.getZone(2, 5).setPerso(p);
        System.out.println("Qui a gagné? "+m.quiAGagne());
        ArrayList<Item> listItem = new ArrayList<>();
        listItem.add(Item.GOAL);
        listItem.add(Item.CARROTTE);
        System.out.println("La liste contient un goal?"+listItem.contains(Item.GOAL));
        System.out.println("La liste ne contientpas  un panier?"+listItem.contains(Item.PANIER));
        /*
        m.getZone(new Coordonnees(3,3)).setItem(Item.GOAL);
        System.out.println("La zone 3,3 contient le GOAL? "+m.getZone(3, 3).contientGoal());
        m.getZone(3, 3).getItem().setVisible(true);
        m.getZone(3, 4).setEtat(Etat.ARBRE);
        
        m.getZone(3, 3).setPerso(p);
        Action a = new Couper(m);
        System.out.println("Couper est possible : "+a.isPossible(3, 3));
        a.doIt(m.getZone(3, 3), m.getZone(3, 4));
        System.out.println(m.getZone(3, 4).getEtat());
        //
        //System.out.println("Peut on fouiller : "+a.isZonePossible(3, 3));
        //System.out.println(m.getZone(3, 3).contientPerso());
        //m.getZone(3, 3).setPerso(m.getZone(3, 3).getPerso());
        //a.doIt(m.getZone(new Coordonnees(3,3)), m.getZone(new Coordonnees(3,4)));
        /*
        ListeActions lA = new ListeActions(m, e);
        for(Action a : lA.getActionsPossible(3, 3)){
            System.out.println(a);
            }
        Action a = new Creuser(m);
        System.out.println(a.isPossible(3, 3));*/
    }
}
