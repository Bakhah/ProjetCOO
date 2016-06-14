/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import models.Item;
import models.Personnage;
import models.Zone;

/**
 *
 * @author bakhah
 */
public class ItemFoundDialog extends JOptionPane
{

    private final Personnage perso;
    private final Zone zone;

    /**
     *Affiche un pop-up en cas de Fouille d'un joueur
     * @param p Le Personnage
     * @param z La zone
     */
    public ItemFoundDialog(Personnage p, Zone z)
    {
        this.perso = p;
        this.zone = z;
        if (this.zone.contientItem())
        {
            init();
        } else
        {
            showMessageDialog(this, "Vous n'avez rien trouvé...");
        }
    }

    private void init()
    {
        if (this.zone.getItem() != Item.GOAL)
        {
            showMessageDialog(this, "Vous avez trouvé " + setRandomStr());
        } else
        {
            showMessageDialog(this, "Vous avez trouvé le Goal !!! Félicitations ! \n N'oubliez pas de le ramasser !");
        }
    }

    private String setRandomStr()
    {
        String str1 = "une chaussette trouée... Pas vraiment intéressant.";
        String str2 = "un os de lapin... Mouais...";
        String str3 = "le GO... Ah non en fait...";
        String str4 = "une longue-vue... mais elle a l'air dans un sale état... : Poubelle";
        String str5 = "un morceau de moquette ! On sait pas trop ce que ça fait ici...";
        String str6 = "de la terre !!! Mouais...";
        String str7 = "un truc qui brille... Mais serait-ce ??? Ah non, juste un caillou qui brille";
        String str8 = "une figurine de Timmer-man, le justicier de Javapolis... ça fera peut-être plaisir à quelqu'un.";
        String str9 = "une boîte de nourriture pour poisson rouge... Cool !";

        ArrayList<String> list = new ArrayList<>();

        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.add(str5);
        list.add(str6);
        list.add(str7);
        list.add(str8);
        list.add(str9);

        Random r = new Random();

        return list.get(r.nextInt(10));
    }
}
