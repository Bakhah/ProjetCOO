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
public class Parcelle extends Zone
{
    private Item item;
    
    public Parcelle(Etat etat) // Constructeur test
    {
        super(etat);
        this.item = null;
    }
}
