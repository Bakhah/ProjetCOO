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
    private Personnage personnage;
    
    public Parcelle(Etat etat) // Constructeur test
    {
        super(etat);
        this.item = null;
    }

    @Override
    public boolean setPerso(Personnage perso) {
        this.personnage=perso;
        return true;
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
    public boolean setItem(Item item) {
        this.item=item;
        return true;
    }

    @Override
    public boolean contientItem() {
        return this.item != null;
    }
    

    @Override
    public Personnage getPerso() {
        return this.personnage;
    }

    @Override
    public Item getItem() {
        return this.item;
    }

    @Override
    public boolean itemVisible() {
        return this.item.estVisible();
    }

    @Override
    public boolean setItemVisible(boolean b) {
        this.item.setVisible(b);
        return true;
    }
}
