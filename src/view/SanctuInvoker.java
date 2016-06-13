/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import actions.Deplacement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Monde;
import models.Personnage;
import models.Sanctuaire;
import models.Zone;

/**
 *
 * @author bakhah
 */
public class SanctuInvoker extends JOptionPane
{

    private final Sanctuaire sanctu;
    private final Monde monde;
    private final VueJoueur vuej;

    public SanctuInvoker(Sanctuaire s, Monde m, VueJoueur vuej)
    {
        this.vuej = vuej;
        this.monde = m;
        this.sanctu = s;
        init();
    }

    private void init()
    {
        Deplacement deplacement = new Deplacement(this.monde);
        ArrayList<Zone> listeZones = deplacement.getZonePossible(this.sanctu);
        ArrayList<Personnage> listePerso = this.sanctu.getListePerso();
        
        if (listePerso.isEmpty() || listeZones.isEmpty())
        {
            showMessageDialog(this, "Aucune invocation possible");
        } else
        {
            
            Object[] options = new Object[listePerso.size()];
            for (int i = 0; i < listePerso.size(); i++)
            {
                options[i] = listePerso.get(i).toString();
            }
            
            Object reply = showOptionDialog(this.vuej, "Quel personnage voulez-vous invoquer ?", "Sanctuaire",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            Personnage perso = listePerso.get((int) reply);
            this.sanctu.setPerso(perso);
            
            
            System.out.println(listeZones);

            for (Zone z : listeZones)
            {
                vuej.getVue(z.getCoordonnees().getX(), z.getCoordonnees().getY()).setHighlight(true);
            }
            vuej.getActionListener().init(listeZones, deplacement, this.sanctu);
            perso.setEnJeu(true);
            System.out.println(perso.hashCode());
            this.sanctu.getListePerso().remove(perso);
            vuej.repaint();
        }

    }

}
