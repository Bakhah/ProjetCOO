/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author bakhah
 */
public class Sanctuaire extends Zone
{
    private ArrayList<Personnage> listePerso;
    private Couleur c;

    public Sanctuaire(Coordonnees coordonnees, Couleur couleur)
    {
        super(Etat.VIDE, coordonnees);
        this.listePerso = new ArrayList<Personnage>();
        this.c=couleur;
    }

    public Couleur getC() {
        return c;
    }
    
    @Override
    public boolean setPerso(Personnage perso) {
        return listePerso.add(perso);
    }

    @Override
    public Personnage getPerso() {
        return null;
    }

    @Override
    public boolean contientPerso() {
        return !listePerso.isEmpty();
    }

    @Override
    public boolean peutAccueillirPerso() {
        return true;
    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public boolean setItem(Item item) {
        return false;
    }

    @Override
    public boolean contientItem() {
        return false;
    }

    @Override
    public boolean itemVisible() {
        return false;
    }

    @Override
    public boolean setItemVisible(boolean b) {
        return false;
    }

    @Override
    public void tuerPerso() {
        System.out.println("Tuer une personnage dans un sanctuaire?!!");
    }

    @Override
    public boolean contientGoal() {
        //TODO
        return false;
    }
    
}
