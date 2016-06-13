package packageForTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showOptionDialog;
import models.Couleur;
import models.Equipe;
import models.Monde;
import view.GenerateJeu;
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

        EventQueue.invokeLater(new Runnable()
        {
            final Equipe equipe1 = new Equipe(Couleur.BLEU);
            final Equipe equipe2 = new Equipe(Couleur.ROUGE);
            Monde monde;
            JFrameSelectEquipe selectBleu;
            JFrameSelectEquipe selectRouge;

            @Override
            public void run()
            {
                
                selectBleu = new JFrameSelectEquipe();
                selectBleu.init(equipe1);
                selectRouge = new JFrameSelectEquipe();
                selectRouge.init(equipe2);
                selectBleu.setLocationRelativeTo(null);
                selectRouge.setLocationRelativeTo(null);

                selectBleu.setVisible(true);

                selectBleu.getButtonConfirmer().addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        selectBleu.setVisible(false);
                        selectRouge.setVisible(true);

                    }
                });
                selectRouge.getButtonConfirmer().addActionListener(new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        selectRouge.setVisible(false);
                        Object[] options = {6,10,15};                     
                        Object reply = showOptionDialog(null, "Choisissez la taille du monde", "Taille du monde",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, options, options[0]);                     

                        if ((int)reply == 0)
                            monde = new Monde(6, 6);
                        if ((int)reply == 1)
                            monde = new Monde(10, 10);
                        if ((int)reply == 2)
                            monde = new Monde(15, 15);
                        GenerateJeu gj = new GenerateJeu(equipe1, equipe2, monde);
                    }
                });
            }
        });

    }
}
