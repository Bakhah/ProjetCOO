package packageForTest;

import models.Coordonnees;
import models.Couleur;
import models.Equipe;
import models.Monde;
import models.Piegeur;
import models.Renifleur;
import models.Topographe;
import view.JFrameJeu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bakhah
 */
public class MainTest
{

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(JFrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(JFrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(JFrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(JFrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Monde monde = new Monde(10, 10); 
                Equipe equipe1 = new Equipe(Couleur.BLEU);
                Equipe equipe2 = new Equipe(Couleur.ROUGE);
                
                equipe1.addPerso(new Piegeur(equipe1));
                System.out.println(equipe1.getListePerso().get(0).hashCode());
                equipe1.addPerso(new Renifleur(equipe1));
                equipe1.addPerso(new Topographe(equipe1));
                equipe1.addPerso(new Piegeur(equipe1));
                equipe1.addPerso(new Topographe(equipe1));
                
                equipe2.addPerso(new Topographe(equipe2));
                equipe2.addPerso(new Renifleur(equipe2));
                equipe2.addPerso(new Topographe(equipe2));
                equipe2.addPerso(new Piegeur(equipe2));
                equipe2.addPerso(new Topographe(equipe2));
                
                monde.getSanctuaire(Couleur.BLEU).initialize(equipe1);
                monde.getSanctuaire(Couleur.ROUGE).initialize(equipe2);
                
                JFrameJeu frame1 = new JFrameJeu(equipe1, monde);                 
                frame1.setVisible(true);
                frame1.pack();
                frame1.getVueJoueur().refreshVisibility();
                
                JFrameJeu frame2 = new JFrameJeu(equipe2, monde);               
                frame2.setVisible(false);
                frame2.pack();               
                frame2.getVueJoueur().refreshVisibility();
                
                frame1.setOtherFrame(frame2);
                frame2.setOtherFrame(frame1);
               /* equipe1.addPerso(new Piegeur(equipe1));
                equipe1.getListePerso().get(0).setCoord(new Coordonnees(5, 5));
                monde.getZone(5, 5).setPerso(equipe1.getListePerso().get(0));
                
                equipe1.addPerso(new Renifleur(equipe1));
                equipe1.getListePerso().get(1).setCoord(new Coordonnees(7, 5));
                monde.getZone(7, 5).setPerso(equipe1.getListePerso().get(1));
                
                equipe1.addPerso(new Topographe(equipe1));
                equipe1.getListePerso().get(2).setCoord(new Coordonnees(3, 3));
                monde.getZone(3, 3).setPerso(equipe1.getListePerso().get(2));
                
                equipe1.addPerso(new Piegeur(equipe1));
                equipe1.getListePerso().get(3).setCoord(new Coordonnees(2, 1));
                monde.getZone(2, 1).setPerso(equipe1.getListePerso().get(3));
                
                equipe1.addPerso(new Topographe(equipe1));
                equipe1.getListePerso().get(4).setCoord(new Coordonnees(6, 8));
                monde.getZone(6, 8).setPerso(equipe1.getListePerso().get(4));
                
                JFrameJeu frame1 = new JFrameJeu(equipe1, monde);               
                frame1.setVisible(true);
                frame1.pack();
                frame1.getVueJoueur().refreshVisibility();
                
                
                
                Equipe equipe2 = new Equipe(Couleur.ROUGE);
                
                equipe2.addPerso(new Topographe(equipe2));
                equipe2.getListePerso().get(0).setCoord(new Coordonnees(4, 5));
                monde.getZone(4, 5).setPerso(equipe2.getListePerso().get(0));
                
                equipe2.addPerso(new Renifleur(equipe2));
                equipe2.getListePerso().get(1).setCoord(new Coordonnees(7, 5));
                monde.getZone(7, 5).setPerso(equipe2.getListePerso().get(1));
                
                equipe2.addPerso(new Topographe(equipe2));
                equipe2.getListePerso().get(2).setCoord(new Coordonnees(2, 3));
                monde.getZone(2, 3).setPerso(equipe2.getListePerso().get(2));
                
                equipe2.addPerso(new Piegeur(equipe2));
                equipe2.getListePerso().get(3).setCoord(new Coordonnees(1, 1));
                monde.getZone(1, 1).setPerso(equipe2.getListePerso().get(3));
                
                equipe2.addPerso(new Topographe(equipe2));
                equipe2.getListePerso().get(4).setCoord(new Coordonnees(5, 8));
                monde.getZone(5, 8).setPerso(equipe2.getListePerso().get(4));
                
                JFrameJeu frame2 = new JFrameJeu(equipe2, monde);               
                frame2.setVisible(false);
                frame2.pack();
                
                frame2.getVueJoueur().refreshVisibility();
                
                frame1.setOtherFrame(frame2);
                frame2.setOtherFrame(frame1);
                */

            }
        });
    }
}
