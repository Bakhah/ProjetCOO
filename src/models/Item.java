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
    GOAL("goal"),
    LONGUEVUE("longue-vue"),
    BASKETS("baskets"),
    BOULECRISTAL("bouleCristal"),
    DETECTEUR("detecteur");
    
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
        if (rand < 15){
            return Item.BASKETS;
        } else{
            if (rand < 30){
                return Item.BOULECRISTAL;
            } else{
                if (rand < 45){
                    return Item.DETECTEUR;
                } else{
                    if (rand < 60){
                        return Item.LONGUEVUE;
                    } else{
                        return null;
                    }
                }
            }
        }
    }
}
