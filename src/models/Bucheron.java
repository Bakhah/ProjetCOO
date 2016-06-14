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
 * @author Louis
 */
public class Bucheron extends Personnage
{

    /**
     * Crée un personnage Bucheron
     *
     * @param equipe Equipe
     */
    public Bucheron(Equipe equipe)
    {
        super(equipe);
        super.setTypeDep(TypeDeplacement.CROIX);
        super.nom = "Bucheron";
    }

    /**
     * Retourne l'icone du Personnage
     *
     * @return
     */
    @Override
    public Image getIcon()
    {
        if (super.getCouleur() == Couleur.BLEU)
        {
            return Toolkit.getDefaultToolkit().createImage(getClass().getResource("/img/buchbleu.png"));
        } else
        {
            if (super.getCouleur() == Couleur.ROUGE)
            {
                return Toolkit.getDefaultToolkit().createImage(getClass().getResource("/img/buchrouge.png"));
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "Bucheron";
    }
}
