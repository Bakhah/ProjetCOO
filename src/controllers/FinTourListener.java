/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.JFrameJeu;

/**
 *
 * @author bakhah
 */
public class FinTourListener implements ActionListener
{
    private JFrameJeu frame;
    private JFrameJeu autreFrame;

    public FinTourListener(JFrameJeu frame, JFrameJeu autreFrame)
    {
        this.frame = frame;
        this.autreFrame = autreFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
       this.autreFrame.setLocation(frame.getLocation());
       this.autreFrame.setVisible(true);      
       this.frame.setVisible(false);
       
       
    }
    
}
