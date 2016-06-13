/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import actions.Action;
import actions.Couper;
import actions.Creuser;
import actions.Deplacement;
import actions.Fouiller;
import actions.ListeActions;
import actions.Ramasser;
import actions.Reboucher;
import controllers.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Zone;

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
        int posX = vue.getZone().getCoordonnees().getX();
        int posY = vue.getZone().getCoordonnees().getY();

        ArrayList<Action> actions = listeActions.getActionsPossible(posX, posY);

        System.out.println(actions);

        if (actions.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Pas d'action possible");
        } else
        {

            Object[] options = new Object[actions.size()];
            for (int i = 0; i < actions.size(); i++)
            {
                options[i] = actions.get(i).toStringButton();
            }

            Object reply = showOptionDialog(null, "Choisissez votre action :", vue.getZone().getPerso().toString(),
                    DEFAULT_OPTION, PLAIN_MESSAGE,
                    null, options, options[0]);

            Action action = actions.get((int) reply);

            if (action instanceof Creuser)
            {
                ArrayList<Zone> list = action.getZonePossible(posX, posY);

                for (Zone z : list)
                {
                    vuej.getVue(z.getCoordonnees().getX(), z.getCoordonnees().getY()).setHighlight(true);
                }
                vuej.getActionListener().init(list, action, vue.getZone());

            }
            if (action instanceof Fouiller)
            {
                Zone z = vuej.getVue(posX, posY).getZone();
                action.doIt(z, z);

            }
            if (action instanceof Reboucher)
            {
                ArrayList<Zone> list = action.getZonePossible(posX, posY);

                for (Zone z : list)
                {
                    vuej.getVue(z.getCoordonnees().getX(), z.getCoordonnees().getY()).setHighlight(true);

                }
                vuej.getActionListener().init(list, action, vue.getZone());
            }
            if (action instanceof Ramasser)
            {
                ArrayList<Zone> list = action.getZonePossible(posX, posY);

                for (Zone z : list)
                {
                    vuej.getVue(z.getCoordonnees().getX(), z.getCoordonnees().getY()).setHighlight(true);

                }
                vuej.getActionListener().init(list, action, vue.getZone());
            }
            if (action instanceof Couper)
            {
                ArrayList<Zone> list = action.getZonePossible(posX, posY);

                for (Zone z : list)
                {
                    vuej.getVue(z.getCoordonnees().getX(), z.getCoordonnees().getY()).setHighlight(true);

                }
                vuej.getActionListener().init(list, action, vue.getZone());
            }
            if (action instanceof Deplacement)
            {
                ArrayList<Zone> list = action.getZonePossible(posX, posY);

                for (Zone z : list)
                {
                    vuej.getVue(z.getCoordonnees().getX(), z.getCoordonnees().getY()).setHighlight(true);
                }
                
                
                vuej.getActionListener().init(list, action, vue.getZone());
            }
            vuej.getVue(posX, posY).setHighlight(false);
            vuej.repaint();
        }

    }

}
