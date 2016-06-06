/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import actions.Action;
import actions.ListeActions;
import controllers.ActionListener;
import controllers.SelectionListener;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.Equipe;
import models.Monde;
import models.Personnage;
import models.Topographe;
import models.Zone;

/**
 *
 * @author bakhah
 */
public class VueJoueur extends JPanel
{

    private Vue[][] tabVues;
    private Equipe equipe;
    private Monde monde;
    private ListeActions listeA;

    public VueJoueur()
    {

    }

    public void setComponent(Equipe e, Monde m, ListeActions listeA) //contstructeur test
        {
        this.monde = m;
        this.equipe = e;
        this.listeA = listeA;
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
        addMouseListener(new SelectionListener(this, listeA));
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

    public Vue getVue(Personnage perso)
    {
        for (Component c : this.getComponents())
        {
            Vue v = (Vue)c;
            if (v.getZone().contientPerso())
                if (v.getZone().getPerso().equals(perso))
                    return v;
            
        }
        return null;
    }

    public int getTailleTableau()
    {
        return this.monde.getHauteur();
    }

    public Equipe getEquipe()
    {
        return this.equipe;
    }
    public void killSelection()
    {
        for (Component c : this.getComponents())
        {
            Vue v = (Vue)c;
            v.setHighlight(false);
        }
        repaint();
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
    
    public void selectGoal() // CHEAT
    {
        for (Component c : this.getComponents())
        {
            Vue v = (Vue) c;
            if (v.getZone().contientGoal())
            {
                v.setHighlight(true);
                repaint();
            }
        }
    }
    public void waitAction(ArrayList<Zone> listZones, Action action, Zone zoneDepart)
    {
        ActionListener al = new ActionListener(this, listZones, action, zoneDepart);
        addMouseListener(al);
        
    }

    public void refreshVisibility()
    {
        for (int y = 0; y < monde.getHauteur(); y++)
        {
            for (int x = 0; x < monde.getLargeur(); x++)
            {
                Vue v = this.getVue(x, y);
                if (v.isVueVisible())
                {
                    v.setFog(true);
                }

            }
        }

        for (int y = 0; y < monde.getHauteur(); y++)
        {
            for (int x = 0; x < monde.getLargeur(); x++)
            {
                Vue v = this.getVue(x, y);
                if (v.getZone().contientPerso())
                {
                    Personnage perso = v.getZone().getPerso();

                    if (perso.estDeCouleur(equipe.getCouleur()))
                    {
                        v.setZone(this.monde.getZone(x, y));
                        v.setVueVisible(true);

                        if (perso instanceof Topographe)
                        {
                            getVue(x - 1, y - 1).setVueVisible(true); getVue(x - 1, y - 1).setZone(this.monde.getZone(x - 1, y - 1));
                            getVue(x, y - 1).setVueVisible(true); getVue(x, y - 1).setZone(this.monde.getZone(x, y - 1));
                            getVue(x - 1, y).setVueVisible(true); getVue(x - 1, y).setZone(this.monde.getZone(x - 1, y));
                            getVue(x + 1, y + 1).setVueVisible(true); getVue(x + 1, y + 1).setZone(this.monde.getZone(x + 1, y + 1));
                            getVue(x + 1, y).setVueVisible(true); getVue(x + 1, y).setZone(this.monde.getZone(x + 1, y));
                            getVue(x, y + 1).setVueVisible(true); getVue(x, y + 1).setZone(this.monde.getZone(x, y + 1));
                            getVue(x - 1, y + 1).setVueVisible(true); getVue(x - 1, y + 1).setZone(this.monde.getZone(x - 1, y + 1));
                            getVue(x + 1, y - 1).setVueVisible(true); getVue(x + 1, y - 1).setZone(this.monde.getZone(x + 1, y - 1));
                        }
                    }
                }
            }
        }
    }

}
