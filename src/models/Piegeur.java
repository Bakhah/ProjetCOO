/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author bakhah
 */
public class Piegeur extends Personnage
{

    public Piegeur(Equipe e)
    {
        super(e);
        super.nom = "Piégeur";
    }

    @Override
    public Image getIcon()
    {
        if (super.getCouleur() == Couleur.BLEU)
        {
            return Toolkit.getDefaultToolkit().createImage(getClass().getResource("/img/piegbleu.png"));
        } else
        {
            if (super.getCouleur() == Couleur.ROUGE)
            {
                return Toolkit.getDefaultToolkit().createImage(getClass().getResource("/img/piegrouge.png"));
            }
        }
        return null;
    }
}
