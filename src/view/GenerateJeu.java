/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import models.Couleur;
import models.Equipe;
import models.Monde;

/**
 *
 * @author hourdinf
 */
public class GenerateJeu
{
    public GenerateJeu(Equipe equipe1, Equipe equipe2, Monde monde)
    {
        JFrameJeu frame1 = new JFrameJeu(equipe1, monde);
        JFrameJeu frame2 = new JFrameJeu(equipe2, monde);
        
        frame1.setOtherFrame(frame2);
        frame2.setOtherFrame(frame1);
        
        monde.getSanctuaire(Couleur.BLEU).initialize(equipe1);
        monde.getSanctuaire(Couleur.ROUGE).initialize(equipe2);
        
        frame1.getVueJoueur().refreshVisibility();
        frame2.getVueJoueur().refreshVisibility();
        
        
        
        frame1.setVisible(true);
                
    }
}
