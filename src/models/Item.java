/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
}
