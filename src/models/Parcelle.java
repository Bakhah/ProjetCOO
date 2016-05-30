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

    @Override
    public boolean setPerso(Personnage perso) {
        //TO-DO
        return false;
    }

    @Override
    public Personnage getPerso() {
        return super.getPerso();
    }

    @Override
    public boolean contientPerso() {
        return this.getPerso() != null;
    }

    @Override
    /**
     * une parcelle peut accueillr un personnage si :
     * - elle n'en contient pas
     * - son état est VIDE ou TROU
     */
    public boolean peutAccueillirPerso() {
        return this.contientPerso() && (super.getEtat()==Etat.TROU || super.getEtat()==Etat.VIDE);
    }

    @Override
    public boolean setItem(Item item)
    {
        this.item = item;
        return true;
    }

    @Override
    public boolean contientItem()
    {
        if (this.item != null)
                return true;
        else 
            return false;
    }
}
