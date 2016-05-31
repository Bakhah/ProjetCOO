/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import models.Equipe;
import models.Monde;

/**
 *
 * @author bakhah
 */
public class VueJoueur extends JPanel
{
    
    
    private Vue[][] tabVues;
    private Equipe e;
    private Monde monde;

    /**
     *COnstructeur pour TESTER
     */
    public VueJoueur(Equipe e, Monde m) //contstructeur test
    {
        int width = m.getLargeur();
        int height = m.getHauteur();
        this.e = e;
        setLayout(new GridLayout(width, height));
        tabVues = new Vue[width][height];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                tabVues[x][y] = new Vue(m.getZone(x, y), true, false, false);
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
