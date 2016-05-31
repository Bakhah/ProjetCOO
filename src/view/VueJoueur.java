/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import models.Equipe;

/**
 *
 * @author bakhah
 */
public class VueJoueur extends JPanel
{
    
    
    private Vue[][] tabVues;
    private Equipe e;

    /**
     *COnstructeur pour TESTER
     */
    public VueJoueur(Equipe e) //contstructeur test
    {
        this.e = e;
        setLayout(new GridLayout(10, 10));
        tabVues = new Vue[10][10];

        for (int y = 0; y < 10; y++)
        {
            for (int x = 0; x < 10; x++)
            {
                tabVues[x][y] = new Vue();
                add(tabVues[x][y]);
            }
        }

    }
    
    /**
     * Récupère la Vue aux coordonnées x,y
     * 
     * @param x Coordonnée x de la Vue
     * @param y Coordonnée y de la Vue
     * @return la Vue
     */
    public Vue getVue(int x, int y)
    {
        return this.tabVues[x][y];
    }

}
