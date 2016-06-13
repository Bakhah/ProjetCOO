package packageForTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Couleur;
import models.Equipe;
import view.JFrameJeu;
import view.JFrameSelectEquipe;

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
                Equipe equipe1 = new Equipe(Couleur.BLEU);
                Equipe equipe2 = new Equipe(Couleur.ROUGE);
                final JFrameSelectEquipe frameEquipeBleu = new JFrameSelectEquipe();
                final JFrameSelectEquipe frameEquipeRouge = new JFrameSelectEquipe();
                frameEquipeBleu.init(equipe1);
                frameEquipeRouge.init(equipe2);
                frameEquipeBleu.setVisible(true);
                frameEquipeBleu.getButtonConfirmer().addActionListener(new ActionListener()
                {
                    
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        frameEquipeBleu.dispose();
                        frameEquipeRouge.setVisible(true);
                    }
                });
                frameEquipeRouge.getButtonConfirmer().addActionListener(new ActionListener()
                {
                    
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        frameEquipeRouge.dispose();
                    }
                });
                System.out.println(equipe1.getListePerso().size());
                System.out.println(equipe2.getListePerso().size());

            }
        });
    }
}
