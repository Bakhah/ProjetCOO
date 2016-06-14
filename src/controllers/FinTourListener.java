/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.JFrameJeu;

/**
 *
 * @author bakhah
 */
public class FinTourListener implements ActionListener
{

    private final JFrameJeu frame;
    private final JFrameJeu autreFrame;

    public FinTourListener(JFrameJeu frame, JFrameJeu autreFrame)
    {
        this.frame = frame;
        this.autreFrame = autreFrame;
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        int reply = JOptionPane.showConfirmDialog(frame, "Êtes-vous sûr de vouloir terminer votre tour ?", "Fin du tour", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            this.frame.getMonde().tuerLesPersoAuDessusDUnTrou(frame.getEquipe());           
            this.frame.getEquipe().resetActionPoint();
            this.autreFrame.setLocation(frame.getLocation());
            this.autreFrame.setVisible(true);
            this.frame.setVisible(false);
            try
            {
                this.frame.refreshEquipePanel();
            } catch (IOException ex)
            {
                Logger.getLogger(FinTourListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            
        }

    }

}
