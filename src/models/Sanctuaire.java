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
    private Personnage waitingPerso;
    private final ArrayList<Personnage> listePerso;
    private final Couleur c;

    public Sanctuaire(Coordonnees coordonnees, Couleur couleur)
    {
        super(Etat.SANCTUAIRE, coordonnees);
        this.listePerso = new ArrayList<>();
        this.c = couleur;
    }

    public Couleur getC()
    {
        return c;
    }

    @Override  
    public boolean setPerso(Personnage perso)
    {
        this.waitingPerso = perso;
        return true;
    }

   

    public void initialize(Equipe e)
    {
        for (int i = 0; i < e.getListePerso().size(); i++)
        {
            this.listePerso.add(e.getPerso(i));
        }
    }
    public void addPersoToList(Personnage p)
    {
        this.listePerso.add(p);
    }

    @Override
    public Personnage getPerso()
    {
               return this.waitingPerso;
    }
    public ArrayList<Personnage> getListePerso()
    {
        return this.listePerso;
    }

    @Override
    public boolean contientPerso() //La case sanctuaire ne contient pas de personnage
    {
        return false;
    }
    public boolean haveWaitingPerso()
    {
        return this.waitingPerso != null;
    }

    @Override
    public boolean peutAccueillirPerso()
    {
        return false;
    }

    @Override
    public Item getItem()
    {
        return null;
    }

    @Override
    public boolean setItem(Item item)
    {
        return false;
    }

    @Override
    public boolean contientItem()
    {
        return false;
    }

    @Override
    public boolean itemVisible()
    {
        return false;
    }

    @Override
    public boolean setItemVisible(boolean b)
    {
        return false;
    }

    @Override
    public void tuerPerso()
    {
        System.out.println("Tuer une personnage dans un sanctuaire?!!");
    }

    @Override
    public boolean contientGoal()
    {
       return false;
    }

}
