/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import actions.Action;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import models.Sanctuaire;
import models.Zone;
import view.VueJoueur;

/**
 *
 * @author hourdinf
 */
public class ActionListener extends Observable implements MouseListener
{

    private final VueJoueur vueJoueur;
    private ArrayList<Zone> listZone;
    private Action action;
    private Zone zoneDepart;
    private boolean active;

    public ActionListener(VueJoueur vuej)
    {
        this.active = false;
        this.vueJoueur = vuej;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (active == true)
        {
            int posX = e.getX() / (vueJoueur.getWidth() / vueJoueur.getTailleTableau());
            int posY = e.getY() / (vueJoueur.getHeight() / vueJoueur.getTailleTableau());
            Zone z = vueJoueur.getVue(posX, posY).getZone();

            if (listZone.contains(z))
            {
                if (zoneDepart instanceof Sanctuaire)
                {
                    System.out.println("!o!");
                    Sanctuaire s = (Sanctuaire) zoneDepart;
                    s.getPerso().setEnJeu(true);
                    s.getListePerso().remove(s.getPerso());

                }

                action.doIt(zoneDepart, vueJoueur.getVue(posX, posY).getZone());
                setChanged();
                notifyObservers();
                vueJoueur.refreshVisibility();
                vueJoueur.repaint();
                dispose();
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

    public void init(ArrayList<Zone> listZone, Action action, Zone zoneDepart)
    {
        this.listZone = listZone;
        this.action = action;
        this.zoneDepart = zoneDepart;
        this.active = true;
    }

    private void invoke()
    {

    }

    public void dispose()
    {
        this.active = false;
    }

}
