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
public class Piegeur extends Personnage
{

    public Piegeur(String equipe)
    {
        super(equipe);

    }

    @Override
    public Image getIcon()
    {
        if (this.getEquipe() == "Bleu")
        {
            try
            {
                return ImageIO.read(getClass().getResource("/img/piegbleu.png"));
            } catch (IOException ex)
            {
                Logger.getLogger(Piegeur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            if (this.getEquipe() == "Rouge")
            {
                try
                {
                    return ImageIO.read(getClass().getResource("/img/piegrouge.png"));
                } catch (IOException ex)
                {
                    Logger.getLogger(Piegeur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;

    }

}
