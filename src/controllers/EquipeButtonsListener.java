/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.VueJoueur;

/**
 *
 * @author bakhah
 */
public class EquipeButtonsListener implements ActionListener
{
    private final VueJoueur vuej;
    
    public EquipeButtonsListener(VueJoueur vuej)
    {
        this.vuej = vuej;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
       
    }
    
}
