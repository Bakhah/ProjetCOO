/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;
import view.VueJoueur;

/**
 *
 * @author hourdinf
 */
public class AffichageTxtListener implements java.awt.event.ActionListener
{
    private final VueJoueur vuej;
    
    public AffichageTxtListener(VueJoueur vuej)
    {
        this.vuej = vuej;
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        vuej.setAffichageTxt();
    }
    
}
