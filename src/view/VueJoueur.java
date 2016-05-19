/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import models.Zone;

/**
 *
 * @author bakhah
 */
public class VueJoueur
{
    private Vue[][] tabVues;
    
    public VueJoueur() //contstructeur test
    {
        tabVues = new Vue[10][10];
        
        for (int y = 0; y < 10; y++)
            for (int x = 0; x < 10; x++)
            {
                tabVues[x][y] = new Vue();
            }
    }
    public Vue getVue(int x, int y)
    {
        return this.tabVues[x][y];
    }
    
    @Override
    public String toString() // Affiche une version txt de VueJoueur
    {
        StringBuilder str = new StringBuilder();
        
        for (int y = 0; y < 10; y++)
        {
            for (int x = 0; x < 10; x++)
            {
                str.append(tabVues[x][y].toString());
                str.append(' ');
            }
            str.append('\n');
        }
        
        return str.toString();
    }
            
}
