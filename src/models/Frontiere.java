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
public class Frontiere extends Zone
{

    public Frontiere(Coordonnees coordonnees)
    {
        super(Etat.ROCHE, coordonnees); //BLABLA
    }

    @Override
    public boolean setPerso(Personnage perso)
    {
        return false;
    }

    @Override
    public Personnage getPerso()
    {
        return null;
    }

    @Override
    public boolean contientPerso()
    {
        return false;
    }

    @Override
    public boolean peutAccueillirPerso()
    {
        return false;
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

    public Item getItem()
    {
        return null;
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
        System.out.println("Tuer un perso dans une frontière?!!");
    }

    @Override
    public boolean contientGoal()
    {
        return false;
    }
}
