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
    }
}
