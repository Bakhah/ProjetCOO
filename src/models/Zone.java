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
    private Personnage personnage;
    private Etat etat;
    private Item item;
    
    public abstract boolean setPerso(Personnage perso);
    public abstract boolean contientPerso();
    public abstract boolean peutAccueillirPerso();
    public abstract boolean setItem(Item item);
    public abstract boolean contientItem();

    public Zone(Etat etat) // Constructeur Test
    {
        this.etat = etat;
    }

    public Personnage getPerso(){
            return this.personnage;
    }
    
    public Item  getItem(){
        return this.item;
    }
    

    public Etat getEtat()
    {
        return this.etat;
    }

    public void setEtat(Etat etat)
    {
        this.etat = etat;
    }

    @Override
    public String toString()
    {
        return this.getClass() + "";
    }
}
