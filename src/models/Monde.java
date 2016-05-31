/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author bakhah
 */
public class Monde
{
    private Zone[][] tabZone;
    private int largeur;
    private int hauteur;
    
    /**
     * instancie un monde de x zones de large sur Y zones de hauteur 
     */
    public Monde(int x, int y){
        this.largeur=x;
        this.hauteur=y;
        this.tabZone = new Zone [x][y];
        this.setFtrontiere();
        this.generateTerrain();
        //TO-DO
    }
    
    public Zone getZone(int x, int y){
        return this.tabZone[x][y];
    }
    /**
     * Retourn la largeur x du monde 
     * @return int
     */
    public int getLargeur(){
        return this.tabZone.length;
    }
    /**
     * Retourne la hauteur y du monde 
     * @return int
     */
    public int getHauteur(){
        return this.tabZone[0].length;
    }
    public boolean zoneExist(int x,int y){
        return x >= 0 && x < this.getLargeur() && y >= 0 && y < this.getHauteur();
    }
    private void setFtrontiere(){
        //Bordure NORD
        for (int i = 0; i<this.largeur;i++){
            this.tabZone[i][0]= new Frontiere();
        }
        //Bordure SUD
        for (int i = 0; i<this.largeur;i++){
            this.tabZone[i][hauteur-1]= new Frontiere();
        }
        //Bordure OUEST
        for (int i = 1; i<this.hauteur-1;i++){
            this.tabZone[0][i]= new Frontiere();
        }
        //Bordure EST
        for (int i = 1; i<this.hauteur-1;i++){
            this.tabZone[largeur-1][i]= new Frontiere();
        }
        
    }
    private void generateTerrain(){
        //Ne pas réecrir sur les frontières
        for(int i=1; i< largeur-1 ; i++){
            for(int j=1; j< hauteur-1;j++){
                System.out.println(i + " " + j);
                this.tabZone[i][j]= generateRadomZone();
            }
        }
    }
    private Zone generateRadomZone(){ 
        Random r = new Random();
        int rand = r.nextInt(100);
        if(rand<5){
            return new Parcelle(Etat.ROCHE);
        }else if(rand<10){
            return new Parcelle(Etat.TROU);
        }else if(rand<20){
            return new Parcelle(Etat.TAS);
        }else if(rand<30){
            return new Parcelle(Etat.ARBRE);
        }else{
            return new Parcelle(Etat.VIDE);
        }
    }
}
