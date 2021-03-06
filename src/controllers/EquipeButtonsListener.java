/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import actions.ListeActions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Personnage;
import view.ActionSelect;
import view.VueJoueur;

/**
 *
 * @author bakhah
 */
public class EquipeButtonsListener implements ActionListener
{

    private final VueJoueur vuej;
    private final Personnage perso;
    private final ListeActions listeActions;

    public EquipeButtonsListener(VueJoueur vuej, Personnage p, ListeActions listeActions)
    {
        this.vuej = vuej;
        this.perso = p;
        this.listeActions = listeActions;
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        this.vuej.killSelection();
        ActionSelect opt = new ActionSelect(vuej, vuej.getVue(perso.getCoord().getX(), perso.getCoord().getY()), listeActions);
    }

}
