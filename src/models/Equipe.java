/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author lalleaul
 */
public class Equipe
{

    private String couleur;
    private ArrayList<Personnage> listePerso;
    private ArrayList<Item> listeItem;
    private Sanctuaire sanctuaire;

    public Equipe()
    {
        this.listePerso = new ArrayList<>();
        this.listeItem = new ArrayList<>();
    }

    public Equipe(String couleur)
    {
        this();
        this.couleur = couleur;
        this.sanctuaire = null;

    }

    public Equipe(String couleur, Sanctuaire sanctuaire)
    {
        this();
        this.couleur = couleur;
        this.sanctuaire = sanctuaire;
    }

    public void addPerso(Personnage perso)
    {
        this.listePerso.add(perso);
    }

}
