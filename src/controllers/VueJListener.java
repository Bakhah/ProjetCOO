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
                vueJoueur.getVue(posX, posY).setHighlight(true);
                vueJoueur.revalidate();
                vueJoueur.repaint();
                Object[] options =
                {
                    "OK", "CANCEL" // A modifier selon la liste d'actions
                };
                int reply = JOptionPane.showOptionDialog(null, "Choisissez votre action :", "Action",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);
                if (reply == JOptionPane.ABORT) // Selon l'action choisie
                {
                    //TODO
                }
                else
                {
                    vueJoueur.getVue(posX, posY).setHighlight(false);
                    vueJoueur.revalidate();
                    vueJoueur.repaint();
                }
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
