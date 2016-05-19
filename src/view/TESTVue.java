/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import models.Etat;
import models.Parcelle;
import models.Topographe;
import models.Zone;

/**
 *
 * @author bakhah
 */
public class TESTVue
{

    public static void main(String[] args)
    {
        Zone avecJ1 = new Parcelle(Etat.VIDE);
        avecJ1.setPerso(new Topographe(1));
        
        Zone avecJ2 = new Parcelle(Etat.TROU);
        avecJ2.setPerso(new Topographe(2));
        
        VueJoueur vueJ = new VueJoueur();
        vueJ.getVue(5, 5).setZone(new Parcelle((Etat.TAS)));
        vueJ.getVue(2, 2).setZone(new Parcelle((Etat.ARBRE)));
        
        vueJ.getVue(1, 1).setZone(avecJ1);
        vueJ.getVue(3, 5).setZone(avecJ2);
        
        System.out.println(vueJ);
    }
}
