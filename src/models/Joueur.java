/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import view.VueJoueur;

/**
 *
 * @author Louis
 */
public class Joueur
{

    private VueJoueur vueJoueur;
    private Equipe equipe;
    private Controle controle;

    public Joueur(Controle controle)
    {
        this.equipe = equipe;
        this.controle = controle;
    }

    public Equipe getEquipe()
    {
        return this.equipe;
    }

}
