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
public enum Equipe {
    BLEU("bleu"),
    ROUGE("rouge");
    
    private String couleur;
    
    ArrayList<Personnage>   listePerso;
    ArrayList<Item>         listeItem;
    Sanctuaire              sanctuaire;
    

    
    Equipe(String couleur){
        this.couleur    =couleur;
        this.sanctuaire =null;
    }
    Equipe(String couleur,Sanctuaire sanctuaire){
        this.couleur    =couleur;
        this.sanctuaire =sanctuaire;
    }
    
}
