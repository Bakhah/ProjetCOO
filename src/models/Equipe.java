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

    private Couleur couleur;
    ArrayList<Personnage> listePerso;
    ArrayList<Item> listeItem;
    Sanctuaire sanctuaire;
    private boolean isBot;

    public Equipe()
    {
        this.listePerso = new ArrayList<>();
        this.listeItem = new ArrayList<>();
        this.isBot = false;
    }

    public Equipe(Couleur couleur)
    {
        this();
        this.couleur = couleur;
        this.sanctuaire = null;
        this.isBot = false;
    }

    public Equipe(Couleur couleur, Sanctuaire sanctuaire)
    {
        this.couleur = couleur;
        this.sanctuaire = sanctuaire;
        this.listeItem = new ArrayList<>();
        this.listePerso = new ArrayList<>();
        this.isBot = false;
    }

    @Override
    public String toString()
    {
        return this.couleur.toString();
    }

    /**
     *
     * @param sanctuaire
     * @return
     */
    public boolean setSanctuaire(Sanctuaire sanctuaire)
    {
        if (this.sanctuaire == null)
        {
            this.sanctuaire = sanctuaire;
            return true;
        }
        return false;
    }

    public void setBot(boolean b)
    {
        this.isBot = b;
    }

    public boolean isBot()
    {
        return this.isBot;
    }

    public Sanctuaire getSanctuaire()
    {
        return this.sanctuaire;
    }

    /**
     * Ajoute un item à la liste d'items
     *
     * @param nouvelItem
     * @return
     */
    public boolean ajouterItem(Item nouvelItem)
    {
        return this.listeItem.add(nouvelItem);
    }

    public ArrayList<Item> getListItem()
    {
        return this.listeItem;
    }

    public boolean ajouterPerso(Personnage personnage)
    {
        return this.listePerso.add(personnage);
    }

    public Personnage getPerso(int i)
    {
        return this.listePerso.get(i);
    }

    public Couleur getCouleur()
    {
        return couleur;
    }

    public void addPerso(Personnage perso)
    {
        this.listePerso.add(perso);
    }

    public ArrayList<Personnage> getListePerso()
    {
        return this.listePerso;
    }

    public void resetActionPoint()
    {
        int bonus = 0;
        if (this.listeItem.contains(Item.OREILLES))
        {
            bonus = 1;
        }
        for (Personnage p : this.listePerso)
        {
            p.resetActionsRestantes(bonus);
        }
    }

    public void setAllIllimite()
    {
        for (Personnage p : this.listePerso)
        {
            p.setCompteurIllimite();
        }
    }

    public boolean aGagne()
    {
        return this.sanctuaire.contientGoal();
    }

}
