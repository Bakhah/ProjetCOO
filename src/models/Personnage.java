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

    private String equipe;
    private Coordonnees coord;
    private Item item;
    private TypeDeplacement typeDep;

    
    
     public abstract Image getIcon();
    
    public Coordonnees getCoord()
    {
        return coord;
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

    public Personnage(String equipe)
    {
        this.equipe = equipe;
        this.item = null;
        this.coord = null;
    }

    public String getEquipe()
    {
        return this.equipe;
    }

    public Coordonnees getCoordonnees()
    {
        return coord;
    }

    public void setCoordonnees(Coordonnees coord)
    {
        this.coord = coord;
    }



}
