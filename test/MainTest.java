
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Couleur;
import models.Equipe;
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
                try
                {
                    Equipe equipe1 = new Equipe(Couleur.BLEU);
                                       
                    equipe1.addPerso(new Topographe(equipe1));
                    equipe1.addPerso(new Renifleur(equipe1));
                    equipe1.addPerso(new Topographe(equipe1));
                    equipe1.addPerso(new Piegeur(equipe1));
                    equipe1.addPerso(new Topographe(equipe1));
                    
                    JFrameJeu frame = new JFrameJeu(equipe1);
                    frame.setVisible(true);
                    frame.refreshAll();
                    
                    
                } catch (IOException ex)
                {
                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
}
