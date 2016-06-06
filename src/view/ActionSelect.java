/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import actions.Action;
import actions.ListeActions;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author bakhah
 */
public class ActionSelect extends JOptionPane
{

    private final VueJoueur vuej;
    private final Vue vue;
    private final ListeActions listeActions;

    public ActionSelect(VueJoueur vuej, Vue v, ListeActions listeActions)
    {
        this.vuej = vuej;
        this.vue = v;
        this.listeActions = listeActions;
        init();
    }

    private void init()
    {
        
        vue.setHighlight(true);
        vuej.repaint();
        
        ArrayList<Action> actions = listeActions.getActionsPossible(vue.getZone().getCoordonnees().getX(), vue.getZone().getCoordonnees().getY());
        
        
        
        System.out.println(actions);
        
        
        Object[] options = new Object[actions.size()];
        
        for (int i = 0; i < actions.size(); i++)
        {
            options[i] = actions.get(i).toStringButton();
        }
        
        
        
        int reply = JOptionPane.showOptionDialog(null, "Choisissez votre action :", vue.getZone().getPerso().toString(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        if (reply == JOptionPane.ABORT) // Selon l'action choisie
        {
            //TODO
        } else
        {
            vue.setHighlight(false);
            vuej.revalidate();
            vuej.repaint();
        }
    }

}
