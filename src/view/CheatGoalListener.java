/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bakhah
 */
public class CheatGoalListener implements ActionListener
{
    private final VueJoueur vuej;
    
    public CheatGoalListener(VueJoueur vuej)
    {
        this.vuej = vuej;
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        vuej.selectGoal();
        vuej.repaint();
    }
    
}