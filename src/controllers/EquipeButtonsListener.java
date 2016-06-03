/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Personnage;
import view.VueJoueur;

/**
 *
 * @author bakhah
 */
public class EquipeButtonsListener implements ActionListener
{
    private final VueJoueur vuej;
    private final Personnage perso;
    
    public EquipeButtonsListener(VueJoueur vuej, Personnage p)
    {
        this.vuej = vuej;
        this.perso = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        this.vuej.getVue(perso.getCoord().getX(), perso.getCoord().getY()).setHighlight(true);
        vuej.repaint();
    }
    
}
