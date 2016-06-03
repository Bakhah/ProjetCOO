/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author lalleaul
 */
public class Equipe {
    
    private Couleur          couleur;
    private ArrayList<Personnage>   listePerso;
    private ArrayList<Item>         listeItem;
    private Sanctuaire              sanctuaire;
    

    public Equipe()
    {
        this.listePerso = new ArrayList<>();
        this.listeItem = new ArrayList<>();
    }
    Equipe(Couleur couleur,Sanctuaire sanctuaire){
        this.couleur    = couleur;
        this.sanctuaire = sanctuaire;
        this.listeItem  = new ArrayList<>();
        this.listePerso = new ArrayList<>();
    }
    public boolean setSanctuaire(Sanctuaire sanctuaire){
        if(this.sanctuaire==null){
            this.sanctuaire=sanctuaire;
            return true;
        }
        return false;
    }
    public Sanctuaire getSanctuaire(){
        return this.sanctuaire;
    }
    public boolean ajouterItem(Item nouvelItem){
        return this.listeItem.add(nouvelItem);
    }
    public ArrayList<Item> getListItem(){
        return this.listeItem;
    }
    public boolean ajouterPerso(Personnage personnage){
        return this.listePerso.add(personnage);
    }
    public Personnage getPerso(int i)
    {
        return this.listePerso.get(i);
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public Equipe(Couleur couleur)
    {
        this();
        this.couleur = couleur;
        this.sanctuaire = null;
    }

    public void addPerso(Personnage perso)
    {
        this.listePerso.add(perso);
    }
    public ArrayList<Personnage> getListePerso()
    {
        return this.listePerso;
    }

}
