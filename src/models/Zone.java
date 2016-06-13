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
public abstract class Zone
{
    
    private Etat etat;
    private final Coordonnees c;
    private boolean fouillee;
    
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
        this.fouillee=false;
    }

    public void setFouillee(boolean b)
    {
        this.fouillee = b;
    }
    
    public boolean isFouillee()
    {
        return this.fouillee;
    }
    
    public abstract Personnage getPerso();    
    public abstract Item  getItem();
    public abstract boolean itemVisible();
    public abstract boolean setItemVisible(boolean b);
    public abstract boolean contientGoal();
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
    public String getStringPerso(){
        if(contientPerso())return this.getPerso().toStringAffichage();
        else return " ";
    }
    public String getStringEtat(){
        return this.getEtat().toString();
    }
    public String getStringFouille(){
        if(fouillee) return "X";
        else return " ";
    }
    public boolean persoALeGoal(){
        if(this.contientPerso()){
            return this.getPerso().aLeGoal();
        }else{
            return false;
        }
        
        
    }
}
