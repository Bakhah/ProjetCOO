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
    protected String nom;

    private int compteurActions;
    private int nbActionsRestantes;

    protected boolean estVivant;
    protected boolean enJeu;


    public Personnage(Equipe equipe)
    {
        this.equipe = equipe;
        this.item = null;
        this.coord = null;

        this.compteurActions=1;
        this.nbActionsRestantes=this.compteurActions;

        this.estVivant = true;
        this.enJeu = false;

    }

    public abstract Image getIcon();
    public String toString(){
        return this.nom+" "+this.equipe.toString();
    }
    
    public Coordonnees getCoord()
    {
        return coord;
    }
    public boolean isEnJeu()
    {
        return this.enJeu;
    }
    public void setEnJeu(boolean b)
    {
        this.enJeu = b;
    }
    
    public boolean estVivant()
    {
        return this.estVivant;
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
    
    public void resetActionsRestantes() {
        this.nbActionsRestantes=this.compteurActions;
    }

    public void decrementeNbActions() {
        this.nbActionsRestantes--;
    }
    public boolean peutEncoreJouer(){
        return this.nbActionsRestantes>0;
    }
    public void setCompteurIllimite()
    {
        this.nbActionsRestantes = 1000;
    }
    public boolean aLeGoal(){
        return this.item==Item.GOAL;
    }
    
}
