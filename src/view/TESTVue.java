/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import models.Etat;
import models.Parcelle;

/**
 *
 * @author bakhah
 */
public class TESTVue
{
    public static void main(String[] args)
    {
        VueJoueur vueJ = new VueJoueur();
        vueJ.getVue(5, 5).setZone(new Parcelle((Etat.TAS)));
        System.out.println(vueJ);
    }
}
