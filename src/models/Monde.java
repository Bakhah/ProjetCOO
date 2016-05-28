/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author bakhah
 */
public class Monde
{
    private Zone[][] tabZone;
    
    /**
     * instancie un monde de x zones de large sur Y zones de hauteur 
     */
    public Monde(int x, int y){
        this.tabZone = new Zone [x][y];
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
}
