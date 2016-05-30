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
    ArrayList<Personnage>   listePerso;
    ArrayList<Item>         listeItem;
    Sanctuaire              sanctuaire;
    

    
    Equipe(Couleur couleur){
        this.couleur    = couleur;
        this.sanctuaire = null;
        this.listeItem  = new ArrayList<>();
        this.listePerso = new ArrayList<>();
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
    public ArrayList<Personnage> getListPerso(){
        return this.listePerso;
    }

    public Couleur getCouleur() {
        return couleur;
    }
    
}
