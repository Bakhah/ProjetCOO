/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import models.Personnage;
import view.OptPaneSelect;
import view.VueJoueur;

/**
 *
 * @author hourdinf
 */
public class VueJListener implements MouseListener
{

    private final VueJoueur vueJoueur;

    public VueJListener(VueJoueur v)
    {
        this.vueJoueur = v;
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
                OptPaneSelect opt = new OptPaneSelect(vueJoueur, vueJoueur.getVue(posX, posY));
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
