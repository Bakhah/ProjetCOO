/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import actions.ListeActions;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import javax.swing.JOptionPane;
import models.Personnage;
import models.Sanctuaire;
import view.ActionSelect;
import view.SanctuInvoker;
import view.VueJoueur;

/**
 *
 * @author hourdinf
 */
public class SelectionListener implements MouseListener
{

    private final VueJoueur vueJoueur;
    private final ListeActions listeA;

    public SelectionListener(VueJoueur v, ListeActions listeA)
    {
        this.vueJoueur = v;
        this.listeA = listeA;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        this.vueJoueur.killSelection();
        int posX = e.getX() / (vueJoueur.getWidth() / vueJoueur.getTailleTableau());
        int posY = e.getY() / (vueJoueur.getHeight() / vueJoueur.getTailleTableau());

        if (vueJoueur.getVue(posX, posY).getZone().contientPerso())
        {
            Personnage perso = vueJoueur.getVue(posX, posY).getZone().getPerso();

            if (perso.estDeCouleur(vueJoueur.getEquipe().getCouleur()))
            {
                ActionSelect opt = new ActionSelect(vueJoueur, vueJoueur.getVue(posX, posY), listeA);
            }
        }
        if (vueJoueur.getVue(posX, posY).getZone() instanceof Sanctuaire)
        {
            Sanctuaire s = (Sanctuaire) vueJoueur.getVue(posX, posY).getZone();
            if (s.getC() == this.vueJoueur.getEquipe().getCouleur())
            {
                SanctuInvoker si = new SanctuInvoker((Sanctuaire) vueJoueur.getVue(posX, posY).getZone(), vueJoueur.getMonde(), vueJoueur);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

}
