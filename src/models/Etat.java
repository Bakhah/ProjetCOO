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
public enum Etat
{
    VIDE("O"),
    TROU("@"),
    TAS("T"),
    ROCHE("R"),
    ARBRE("A");
    
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
}
