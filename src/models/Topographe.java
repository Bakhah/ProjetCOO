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
public class Topographe extends Personnage
{

    public Topographe(Equipe e)
    {
        super(e);
        super.setTypeDep(TypeDeplacement.DIAGONALE);
        super.nom = "Topographe";
    }

    @Override
    public Image getIcon()
    {
        if (super.getCouleur() == Couleur.BLEU)
        {
            return Toolkit.getDefaultToolkit().createImage("src/img/topobleu.png");
        } else
        {
            if (super.getCouleur() == Couleur.ROUGE)
            {
                return Toolkit.getDefaultToolkit().createImage("src/img/toporouge.png");
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return "Topographe";
    }

}
