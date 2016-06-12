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
public class Renifleur extends Personnage
{
    public Renifleur(Equipe e)
    {
        super(e);
        super.setTypeDep(TypeDeplacement.CROIX);
        super.nom="Renifleur";
    }

    @Override
    public Image getIcon()
    {
        if (super.getCouleur() == Couleur.BLEU)
        {
            return Toolkit.getDefaultToolkit().createImage("src/img/renibleu.png");
        } else
        {
            if (super.getCouleur() == Couleur.ROUGE)
            {
                return Toolkit.getDefaultToolkit().createImage("src/img/renirouge.png");
            }
        }
        return null;
    }
    @Override
    public String toString()
    {
        return "Renifleur";
    }
    
}
