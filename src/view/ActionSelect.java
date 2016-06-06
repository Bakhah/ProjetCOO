/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import actions.ListeActions;
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
        
        System.out.println(listeActions.getActionsPossible(2, 1));
        
        
        Object[] options =
        {
            "OK", "CANCEL" // A modifier selon la liste d'actions
        };
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
