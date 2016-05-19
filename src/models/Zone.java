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
    private Personnage perso;

    public Zone(Etat etat) // Constructeur Test
    {
        this.etat = etat;
    }

    public Etat getEtat()
    {
        return this.etat;
    }

    @Override
    public String toString()
    {
        return this.getClass() + "";
    }
}
