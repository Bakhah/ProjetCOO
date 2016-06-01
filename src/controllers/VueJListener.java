/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        System.out.println(e.getX() + " " + e.getY());
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
