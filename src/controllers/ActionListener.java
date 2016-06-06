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
import models.Personnage;
import models.Zone;
import view.ActionSelect;
import view.VueJoueur;

/**
 *
 * @author hourdinf
 */
public class ActionListener implements MouseListener
{
    private final VueJoueur vueJoueur; 
    private final ArrayList<Zone> listZone;
    private final Action action;
    private final Zone zoneDepart;
    

    public ActionListener(VueJoueur vuej, ArrayList<Zone> list, Action a, Zone zoneDepart)
    {
        this.vueJoueur = vuej;
        this.listZone = list;
        this.action = a;
        this.zoneDepart = zoneDepart;
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
       
        int posX = e.getX() / (vueJoueur.getWidth() / vueJoueur.getTailleTableau());
        int posY = e.getY() / (vueJoueur.getHeight() / vueJoueur.getTailleTableau());

        if (listZone.contains(vueJoueur.getVue(posX, posY).getZone()))
        {
            action.doIt(zoneDepart, vueJoueur.getVue(posX, posY).getZone());
        }
        vueJoueur.repaint();
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
