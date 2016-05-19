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
public abstract class Personnage
{
    private int equipe;
    
    public Personnage(int equipe)
    {
        this.equipe = equipe;
    }
    
    public int getEquipe()
    {
        return this.equipe;
    }
}
