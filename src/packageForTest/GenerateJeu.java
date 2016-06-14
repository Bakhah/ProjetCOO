/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageForTest;

import models.Couleur;
import models.Equipe;
import models.Monde;
import view.JFrameJeu;

/**
 *
 * @author hourdinf
 */
public class GenerateJeu
{

    /**
     * Génère une partie, après composition des équipes
     *
     * @param equipe1 Equipe Bleu
     * @param equipe2 Equipe Rouge
     * @param monde Le monde
     */
    public GenerateJeu(Equipe equipe1, Equipe equipe2, Monde monde)
    {
        equipe1.setSanctuaire(monde.getSanctuaire(Couleur.BLEU));
        equipe2.setSanctuaire(monde.getSanctuaire(Couleur.ROUGE));
        monde.getSanctuaire(Couleur.BLEU).initialize(equipe1);
        monde.getSanctuaire(Couleur.ROUGE).initialize(equipe2);

        JFrameJeu frame1 = new JFrameJeu(equipe1, monde);
        JFrameJeu frame2 = new JFrameJeu(equipe2, monde);

        frame1.setOtherFrame(frame2);
        frame2.setOtherFrame(frame1);

        frame1.getVueJoueur().refreshVisibility();
        frame2.getVueJoueur().refreshVisibility();

        frame1.setLocationRelativeTo(null);

        frame1.setVisible(true);
        if (frame1.getEquipe().isBot())
        {
            frame1.playAuto();
        }
    }
}
