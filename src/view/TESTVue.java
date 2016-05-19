/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import models.Etat;
import models.Parcelle;
import models.Piegeur;
import models.Renifleur;
import models.Topographe;
import models.Zone;

/**
 *
 * @author bakhah
 */
public class TESTVue
{

    public static void main(String[] args)
    {
        VueJoueur vueJ = new VueJoueur();
        Zone avecJ1 = new Parcelle(Etat.VIDE);
        avecJ1.setPerso(new Topographe(1));
        Zone avecJ1b = new Parcelle(Etat.TROU);
        avecJ1b.setPerso(new Piegeur(1));
        Zone avecJ2 = new Parcelle(Etat.VIDE);
        avecJ2.setPerso(new Renifleur(2));
        Zone avecJ2b = new Parcelle(Etat.VIDE);
        avecJ2b.setPerso(new Topographe(2));
        
        
        
        vueJ.getVue(5, 5).setZone(avecJ1);
        vueJ.getVue(4, 5).setZone(avecJ1b);
        vueJ.getVue(2, 7).setZone(avecJ2);
        vueJ.getVue(5, 7).setZone(avecJ2b);
        
        vueJ.getVue(0, 0).setZone(new Parcelle(Etat.ROCHE));
        vueJ.getVue(0, 5).setZone(new Parcelle(Etat.TROU));
        vueJ.getVue(1, 7).setZone(new Parcelle(Etat.TROU));
        vueJ.getVue(3, 9).setZone(new Parcelle(Etat.ROCHE));
        vueJ.getVue(2, 2).setZone(new Parcelle(Etat.ROCHE));
        vueJ.getVue(4, 8).setZone(new Parcelle(Etat.ROCHE));
        vueJ.getVue(2, 9).setZone(new Parcelle(Etat.ARBRE));
        vueJ.getVue(1, 1).setZone(new Parcelle(Etat.ARBRE));
        
        
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("test");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(500, 500));
                frame.add(vueJ);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
