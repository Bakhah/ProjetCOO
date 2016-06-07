/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author bakhah
 */
public abstract class Zone
{
    
    private Etat etat;
    private Item item;
    private final Coordonnees c;
    
    public abstract boolean setPerso(Personnage perso);
    public abstract boolean contientPerso();
    public abstract boolean peutAccueillirPerso();
    public abstract boolean setItem(Item item);
    public abstract boolean contientItem();
    public abstract void tuerPerso();

    public Zone(Etat etat,Coordonnees coordonnees) // Constructeur Test
    {
        this.etat = etat;
        this.c = coordonnees;
    }

    public abstract Personnage getPerso();    
    public abstract Item  getItem();
    public abstract boolean itemVisible();
    public abstract boolean setItemVisible(boolean b);

    public Etat getEtat()
    {
        return this.etat;
    }

    public void setEtat(Etat etat)
    {
        this.etat = etat;
    }

    public Coordonnees getCoordonnees() {
        return this.c;
    }
    

    @Override
    public String toString()
    {
        return this.getClass() + "";
    }
    public boolean contientGoal()
    {
        return this.item == Item.GOAL;
    }
}
