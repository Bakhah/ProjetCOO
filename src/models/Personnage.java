/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Image;

/**
 *
 * @author bakhah
 */
public abstract class Personnage
{

    protected Equipe equipe;
    protected Coordonnees coord;
    protected Item item;
    protected TypeDeplacement typeDep;
    protected boolean estVivant;

    public Personnage(Equipe equipe)
    {
        this.equipe = equipe;
        this.item = null;
        this.coord = null;
        this.estVivant = true;
    }

    public abstract Image getIcon();

    public Coordonnees getCoord()
    {
        return coord;
    }
    
    public void setVivant(boolean b)
    {
        this.estVivant = b;
    }
    
    public void setCoord(Coordonnees coord)
    {
        this.coord = coord;
    }

    public TypeDeplacement getTypeDep()
    {
        return typeDep;
    }

    public void setTypeDep(TypeDeplacement typeDep)
    {
        this.typeDep = typeDep;
    }

    public Item getItem()
    {
        return this.item;
    }

    public void setItem(Item objet)
    {
        this.item = objet;
    }

    public Couleur getCouleur()
    {
        return this.equipe.getCouleur();
    }

    public Coordonnees getCoordonnees()
    {
        return coord;
    }

    public void setCoordonnees(Coordonnees coord)
    {
        this.coord = coord;
    }

    public boolean estDeCouleur(Couleur autreCouleur)
    {
        return this.equipe.getCouleur() == autreCouleur;
    }
    public Equipe getEquipe()
    {
        return this.equipe;
    }
}
