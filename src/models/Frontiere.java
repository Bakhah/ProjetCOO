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
    
    public Frontiere()
    {
        super(Etat.ROCHE); //BLABLA
    }

    @Override
    public boolean setPerso(Personnage perso) {
        return false;
    }

    @Override
    public Personnage getPerso() {
        return null;
    }

    @Override
    public boolean contientPerso() {
        return false;
    }
}