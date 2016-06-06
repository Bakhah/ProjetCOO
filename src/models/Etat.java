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
public enum Etat
{
    VIDE("O"),
    TROU("@"),
    TAS("T"),
    ROCHE("R"),
    ARBRE("A"),
    SANCTUAIRE("S");
    
    private String str = "";
    
    Etat(String str)
    {
        this.str = str;
    }
    
    @Override
    public String toString()
    {
        return this.str;
    }
    public boolean equals(Etat autreEtat){
        return this.str==autreEtat.str;
    }
    public boolean isAccueilable(){
        return this.str=="@" ||this.str=="O" || this.str=="S";
    }
    public static Etat generateRandom(){
        Random r = new Random();
        int rand = r.nextInt(100);
        if (rand < 5)
        {
            return Etat.ROCHE;
        } else
        {
            if (rand < 10)
            {
                return Etat.TROU;
            } else
            {
                if (rand < 20)
                {
                    return Etat.TAS;
                } else
                {
                    if (rand < 30)
                    {
                        return Etat.ARBRE;
                    } else
                    {
                        return Etat.VIDE;
                    }
                }
            }
        }
    }
}
