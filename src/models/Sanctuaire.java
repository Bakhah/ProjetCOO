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

    public Sanctuaire()
    {
        super(Etat.VIDE);
        this.listePerso = new ArrayList<Personnage>();
    }

    @Override
    public boolean setPerso(Personnage perso) {
        return listePerso.add(perso);
    }

    @Override
    public Personnage getPerso() {
        return listePerso.get(0);
    }

    @Override
    public boolean contientPerso() {
        return listePerso.isEmpty();
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
    
}
