/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import models.Couleur;
import models.Equipe;

/**
 *
 * @author hourdinf
 */
public class VictoireDialog extends JOptionPane
{

    private final Equipe equipe;

    /**
     *Affiche une fenêtre en cas de victoire
     * @param e L'équipe gagnante
     */
    public VictoireDialog(Equipe e)
    {
        this.equipe = e;
        init();
    }

    private void init()
    {
        Object[] optionsButton =
        {
            "Quitter"
        };
        String deb = "L'équipe ";
        String fin = " a gagné !";

        String mid;
        if (this.equipe.getCouleur() == Couleur.BLEU)
        {
            mid = "Bleue";
        } else
        {
            mid = "Rouge";
        }

        Object reply = showOptionDialog(this, deb + mid + fin + "\n Vous avez gagné la partie !", "Félicitations !",
                DEFAULT_OPTION, PLAIN_MESSAGE,
                null, optionsButton, optionsButton[0]);

        if ((int) reply == 0)
        {
            System.exit(0);

        }
    }
}
