/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import actions.ListeActions;
import controllers.ActionListener;
import controllers.SelectionListener;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import models.Equipe;
import models.Frontiere;
import models.Monde;
import models.Parcelle;
import models.Personnage;
import models.Sanctuaire;
import models.Topographe;

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
    private SelectionListener sl;
    ActionListener al = new ActionListener(this);

    /**
     *
     */
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
        sl = new SelectionListener(this, listeA);
        addMouseListener(sl);
        addMouseListener(al);
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

    public ActionListener getActionListener()
    {
        return al;
    }

    public Vue getVue(Personnage perso)
    {
        for (Component c : this.getComponents())
        {
            Vue v = (Vue) c;
            if (v.getZone().contientPerso())
            {
                if (v.getZone().getPerso().equals(perso))
                {
                    return v;
                }
            }

        }
        return null;
    }

    public Monde getMonde()
    {
        return this.monde;
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
            Vue v = (Vue) c;
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

    public void setAllItemsVisible()
    {
        for (int y = 0; y < monde.getHauteur(); y++)
        {
            for (int x = 0; x < monde.getLargeur(); x++)
            {
                if (this.monde.getZone(x, y).contientItem())
                {
                    this.getVue(x, y).setHighlight(true);
                }

            }
        }
    }

    public void setAffichageTxt()
    {
        for (int y = 0; y < monde.getHauteur(); y++)
        {
            for (int x = 0; x < monde.getLargeur(); x++)
            {
                this.getVue(x, y).setAffichageTxt();
            }
        }
    }

    public void selectGoal() // CHEAT
    {
        for (int y = 0; y < monde.getHauteur(); y++)
        {
            for (int x = 0; x < monde.getLargeur(); x++)
            {

                if (this.monde.getZone(x, y) instanceof Parcelle && this.monde.getZone(x, y).contientGoal())
                {
                    this.getVue(x, y).setHighlight(true);
                    repaint();
                }
            }
        }
    }

    public void refreshVisibility()
    {
        setAllFog();

        for (int y = 0; y < monde.getHauteur(); y++)
        {
            for (int x = 0; x < monde.getLargeur(); x++)
            {
                refreshVisibiliteVue(x, y);
            }
        }
    }

    private void setAllFog()
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
    }

    private void refreshVisibiliteVue(int x, int y)
    {
        Vue v = this.getVue(x, y);
        if (v.getZone() instanceof Sanctuaire)
        {
            Sanctuaire s = (Sanctuaire) v.getZone();
            if (s.getC() == this.equipe.getCouleur())
            {
                setVisibleAround(x, y);
            }
        }
        if (v.getZone() instanceof Frontiere)

        {

            v.setVueVisible(true);
        }
        if (v.getZone().contientPerso())
        {
            Personnage p = v.getZone().getPerso();
            if (p.estDeCouleur(equipe.getCouleur()))
            {
                if (p instanceof Topographe)
                {

                    setVisibleAround(x, y);

                } else
                {
                    v.setVueVisible(true);
                }

            }
        }

    }

    private void setVisibleAround(int x, int y)
    {
        getVue(x, y).setVueVisible(true);
        getVue(x, y).setZone(this.monde.getZone(x, y));
        getVue(x - 1, y - 1).setVueVisible(true);
        getVue(x - 1, y - 1).setZone(this.monde.getZone(x - 1, y - 1));
        getVue(x, y - 1).setVueVisible(true);
        getVue(x, y - 1).setZone(this.monde.getZone(x, y - 1));
        getVue(x - 1, y).setVueVisible(true);
        getVue(x - 1, y).setZone(this.monde.getZone(x - 1, y));
        getVue(x + 1, y + 1).setVueVisible(true);
        getVue(x + 1, y + 1).setZone(this.monde.getZone(x + 1, y + 1));
        getVue(x + 1, y).setVueVisible(true);
        getVue(x + 1, y).setZone(this.monde.getZone(x + 1, y));
        getVue(x, y + 1).setVueVisible(true);
        getVue(x, y + 1).setZone(this.monde.getZone(x, y + 1));
        getVue(x - 1, y + 1).setVueVisible(true);
        getVue(x - 1, y + 1).setZone(this.monde.getZone(x - 1, y + 1));
        getVue(x + 1, y - 1).setVueVisible(true);
        getVue(x + 1, y - 1).setZone(this.monde.getZone(x + 1, y - 1));
    }

}
