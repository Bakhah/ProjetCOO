/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Random;

/**
 *
 * @author bakhah
 */
public enum Item
{
    GOAL("Goal !"),
    LAINE("De la laine..."),
    CARROTTE("Une carotte..."),
    LIVRE("Cours de cobol..."),
    OREILLES("Des oreilles de lapin..."),
    PANIER("Un panier...");
    
    private String type;
    private boolean visible;
    
    Item(String type){
        this.type=type;
        this.visible=false;
    }
    public boolean equals(Item autreEnum){
        return this.type==autreEnum.type;
    }
    public boolean estVisible(){
        return this.visible;
    }
    public void setVisible(boolean trueOrFalse){
        this.visible=trueOrFalse;
    }
    static Item generateRadom(){
        Random r = new Random();
        int rand = r.nextInt(100);
        if (rand < 10){
            return Item.CARROTTE;
        } else{
            if (rand < 20){
                return Item.LAINE;
            } else{
                if (rand < 30){
                    return Item.LIVRE;
                } else{
                    if (rand < 40){
                        return Item.OREILLES;
                    } else{
                        if (rand < 50) {
                            return Item.PANIER;
                        }
                        return null;
                    }
                }
            }
        }
    }
}
