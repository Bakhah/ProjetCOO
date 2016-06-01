/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JPanel;
import models.Equipe;
import models.Monde;

/**
 *
 * @author bakhah
 */
public class VueJoueur extends JPanel
{

    private final Vue[][] tabVues;
    private final Equipe e;
    private final Monde monde;

    /**
     * COnstructeur pour TESTER
     *
     * @param e Equipe
     * @param m Monde
     */
    public VueJoueur(Equipe e, Monde m) //contstructeur test
    {
        this.monde = m;
        this.e = e;
        int width = this.monde.getLargeur();
        int height = this.monde.getHauteur();

        setLayout(new GridLayout(width, height));
        tabVues = new Vue[width][height];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                tabVues[x][y] = new Vue(this.monde.getZone(x, y));
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
        return (Vue) this.getComponent(y * monde.getLargeur() + x);
    }

    public void setAllVueVisible()
    {
        for (int y = 0; y < monde.getHauteur(); y++)
        {
            for (int x = 0; x < monde.getLargeur(); x++)
            {
                this.getVue(x, y).setVueVisible(true);
            }
        }
    }
}
