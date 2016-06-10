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
public class Bucheron extends Personnage{

    public Bucheron(Equipe equipe) {
        super(equipe);
        super.setTypeDep(TypeDeplacement.CROIX);
    }

    @Override
    public Image getIcon()
    {
        if (super.getCouleur() == Couleur.BLEU)
        {
            return Toolkit.getDefaultToolkit().createImage("src/img/buchbleu.png");
        } else
        {
            if (super.getCouleur() == Couleur.ROUGE)
            {
                return Toolkit.getDefaultToolkit().createImage("src/img/buchrouge.png");
            }
        }
        return null;
    }
    @Override
    public String toString(){
        return "Bucheron";
    }
}
