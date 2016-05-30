/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Louis
 */
public enum Couleur {
    BLEU('c'),
    ROUGE('c');
    
    private char c;
    
    Couleur(char c){
        this.c=c;
    }
    public char getCouleur(){
        return this.c;
    }
    public boolean equals(Couleur autreCouleur){
        return this.c==autreCouleur.c;
    }
}
