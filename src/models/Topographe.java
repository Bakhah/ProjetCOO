/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author bakhah
 */
public class Topographe extends Personnage
{
    public Topographe(Couleur c)
    {
        super(c);
        super.setTypeDep(TypeDeplacement.DIAGONALE);
    }

    @Override
    public Image getIcon()
    {
        if (super.getCouleur() == Couleur.BLEU)
        {
            try
            {
                return ImageIO.read(getClass().getResource("/img/topobleu.png"));
            } catch (IOException ex)
            {
                Logger.getLogger(Piegeur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            if (super.getCouleur() == Couleur.ROUGE)
            {
                try
                {
                    return ImageIO.read(getClass().getResource("/img/toporouge.png"));
                } catch (IOException ex)
                {
                    Logger.getLogger(Piegeur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;

    }
    
}
