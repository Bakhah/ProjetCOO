/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import actions.Action;
import actions.ListeActions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author L0u15
 */
public class Monde
{

    private Zone[][] tabZone;
    private int largeur;
    private int hauteur;
    private ListeActions listActions;

    private Coordonnees coordSanctBleu;
    private Coordonnees coordSanctRouge;

    /**
     * instancie un monde de x zones de large sur Y zones de hauteur
     */
    public Monde(int largeur, int hauteur)
    {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.coordSanctBleu = new Coordonnees(1, hauteur / 2);
        this.coordSanctRouge = new Coordonnees(largeur - 2, hauteur / 2);
        this.tabZone = new Zone[largeur][hauteur];
        this.setFrontiere();
        this.generateTerrain();
        this.placeTheGoal();
    }

    public ArrayList<Action> getListActions(int x, int y)
    {
        return this.listActions.getActionsPossible(x, y);
    }

    public Zone getZone(int x, int y)
    {
        return this.tabZone[x][y];
    }

    public Zone getZone(Coordonnees coordonnees)
    {
        return this.tabZone[coordonnees.getX()][coordonnees.getY()];
    }

    /**
     * Retourn la largeur x du monde
     *
     * @return int
     */
    public int getLargeur()
    {
        return this.tabZone.length;
    }

    /**
     * Retourne la hauteur y du monde
     *
     * @return int
     */
    public int getHauteur()
    {
        return this.tabZone[0].length;
    }

    public boolean zoneExist(int x, int y)
    {
        return x >= 0 && x < this.getLargeur() && y >= 0 && y < this.getHauteur();
    }

    private void setFrontiere()
    {
        //Bordure NORD
        for (int i = 0; i < this.largeur; i++)
        {
            this.tabZone[i][0] = new Frontiere(new Coordonnees(i, 0));
        }
        //Bordure SUD
        for (int i = 0; i < this.largeur; i++)
        {
            this.tabZone[i][hauteur - 1] = new Frontiere(new Coordonnees(i, hauteur - 1));
        }
        //Bordure OUEST
        for (int i = 1; i < this.hauteur - 1; i++)
        {
            this.tabZone[0][i] = new Frontiere(new Coordonnees(0, i));
        }
        //Bordure EST
        for (int i = 1; i < this.hauteur - 1; i++)
        {
            this.tabZone[largeur - 1][i] = new Frontiere(new Coordonnees(largeur - 1, i));
        }

    }

    private void cleanNearSanctuarys()
    {
        int xB = this.coordSanctBleu.getX();
        int yB = this.coordSanctBleu.getY();
        this.tabZone[xB][yB - 1].setEtat(Etat.VIDE);
        this.tabZone[xB + 1][yB - 1].setEtat(Etat.VIDE);
        this.tabZone[xB + 1][yB].setEtat(Etat.VIDE);
        this.tabZone[xB + 1][yB + 1].setEtat(Etat.VIDE);
        this.tabZone[xB][yB + 1].setEtat(Etat.VIDE);

        int xR = this.coordSanctRouge.getX();
        int yR = this.coordSanctRouge.getY();
        this.tabZone[xR][yR - 1].setEtat(Etat.VIDE);
        this.tabZone[xR][yR + 1].setEtat(Etat.VIDE);
        this.tabZone[xR - 1][yR + 1].setEtat(Etat.VIDE);
        this.tabZone[xR - 1][yR - 1].setEtat(Etat.VIDE);
        this.tabZone[xR - 1][yR].setEtat(Etat.VIDE);
    }

    private void generateTerrain()
    {
        for (int i = 1; i < largeur - 1; i++)
        {
            for (int j = 1; j < hauteur - 1; j++)
            {
                this.tabZone[i][j] = new Parcelle(Etat.generateRandom(), new Coordonnees(i, j));
            }
        }
        this.placeSanctuarys();
        this.cleanNearSanctuarys();
        this.placeItem();
        if (this.getListAccessibleDesDeuxSanctuaire().isEmpty())
        {
            this.generateTerrain();
        }

    }

    // J'utilise maintenant une méthode static d'Etat pour generer un état aleatoire
    /*private Zone generateRadomZone()
     {
     Random r = new Random();
     int rand = r.nextInt(100);
     if (rand < 5)
     {
     return new Parcelle(Etat.ROCHE);
     } else
     {
     if (rand < 10)
     {
     return new Parcelle(Etat.TROU);
     } else
     {
     if (rand < 20)
     {
     return new Parcelle(Etat.TAS);
     } else
     {
     if (rand < 30)
     {
     return new Parcelle(Etat.ARBRE);
     } else
     {
     return new Parcelle(Etat.VIDE);
     }
     }
     }
     }
     }*/
    private void placeItem()
    {
        for (int i = 1; i < largeur - 1; i++)
        {
            for (int j = 1; j < hauteur - 1; j++)
            {
                this.tabZone[i][j].setItem(Item.generateRadom());
            }
        }
    }

    public void placeSanctuarys()
    {
        this.tabZone[coordSanctBleu.getX()][coordSanctBleu.getY()] = new Sanctuaire(coordSanctBleu, Couleur.BLEU);
        this.tabZone[coordSanctRouge.getX()][coordSanctRouge.getY()] = new Sanctuaire(coordSanctRouge, Couleur.ROUGE);
    }
    // METHODES POUR LE PLACEMENT DU GOAL
    //      GENERER UNE LISTE DE CASES ACCESSIBLES PAR LES 2 SANCTUAIRES
    //      PLACER LE GOAL AU HASARD DANS UNE DE CES CASES
    /**
     * Renvoie une liste de toutes les zones accessibles depuis la zone aux
     * coordonnées xy
     *
     * @param x abscisses
     * @param y ordonnées
     * @return
     */
    private LinkedList<Coordonnees> getZonesAccessiblesDepuis(Coordonnees c)
    {
        LinkedList<Coordonnees> listVerte = new LinkedList<>();
        listVerte.add(c);
        for (int i = 0; i < listVerte.size(); i++)
        {
            for (Coordonnees voisine : this.getCoordVoisinesDe(listVerte.get(i).getX(), listVerte.get(i).getY()))
            {
                if (!listVerte.contains(voisine) && this.zoneVivable(voisine))
                {
                    listVerte.add(voisine);
                } else
                {
                }
            }
        }
        return listVerte;
    }

    public ArrayList<Coordonnees> getListAccessibleDesDeuxSanctuaire()
    {
        ArrayList<Coordonnees> list = new ArrayList<>();
        LinkedList<Coordonnees> listBleu = this.getZonesAccessiblesDepuis(coordSanctBleu);
        LinkedList<Coordonnees> listRouge = this.getZonesAccessiblesDepuis(coordSanctRouge);
        for (Coordonnees c : listBleu)
        {
            if (listRouge.contains(c))
            {
                list.add(c);
            }
        }
        list.remove(coordSanctBleu);
        list.remove(coordSanctRouge);
        return list;
    }

    private void placeTheGoal()
    {
        ArrayList<Coordonnees> list = this.getListAccessibleDesDeuxSanctuaire();
        Random r = new Random();
        int rand = r.nextInt(list.size() - 1);
        this.tabZone[list.get(rand).getX()][list.get(rand).getY()].setItem(Item.GOAL);

    }

    private boolean zoneExists(int x, int y)
    {
        return x < largeur - 1 && x > 1 && y < hauteur - 1 && y > 1;
    }

    private boolean zoneVivable(Coordonnees c)
    {
        return !this.getZone(c).getEtat().equals(Etat.ROCHE);
    }

    private ArrayList<Coordonnees> getCoordVoisinesDe(int x, int y)
    {
        ArrayList<Coordonnees> list = new ArrayList<>();
        if (this.zoneExist(x, y - 1))
        {
            list.add(new Coordonnees(x, y - 1));
        }
        if (this.zoneExist(x, y + 1))
        {
            list.add(new Coordonnees(x, y + 1));
        }
        if (this.zoneExist(x - 1, y))
        {
            list.add(new Coordonnees(x - 1, y));
        }
        if (this.zoneExist(x + 1, y))
        {
            list.add(new Coordonnees(x + 1, y));
        }
        return list;
    }
    /*
     public void deplacerPerso(Zone depart, Zone arrivee){
     arrivee.setPerso(depart.getPerso());
     depart.setPerso(null);
     }
     public void creuser(Zone zone){
     if (zone.getEtat()    == Etat.VIDE)zone.setEtat(Etat.TROU);
     else if(zone.getEtat()== Etat.TAS) zone.setEtat(Etat.VIDE);
     }
     public Item ramasser(int x, int y){
     Zone z = this.getZone(x, y);
     Item i = z.getItem();
     z.setItem(null);
     return i;
     }
     public void Reboucher(int x, int y){
     Zone z = this.getZone(x, y);
     if (z.getEtat()    == Etat.TROU)z.setEtat(Etat.VIDE);
     else if(z.getEtat()== Etat.VIDE) z.setEtat(Etat.TAS);
     }
     */

    @Override
    public String toString()
    {
        String s = "";
        for (int h = 0; h < hauteur; h++)
        {
            for (int l = 0; l < largeur; l++)
            {
                s += this.tabZone[l][h].getEtat() + " ";
            }
            s += '\n';
        }
        return s;
    }

    public void tuerLesPersoAuDessusDUnTrou(Equipe equipeQuiJoue)
    {
        for (int h = 1; h < hauteur - 1; h++)
        {
            for (int l = 1; l < largeur - 1; l++)
            {
                Zone z = this.tabZone[l][h];
                if (z.contientPerso() && z.getPerso().getEquipe() == equipeQuiJoue && z.getEtat() == Etat.TROU)
                {
                    z.getPerso().setEnJeu(false);
                    getSanctuaire(z.getPerso().getCouleur()).addPersoToList(z.getPerso());
                    z.tuerPerso();
                }
            }
        }
    }

    public Sanctuaire getSanctuaire(Couleur c)
    {
        if (c == Couleur.BLEU)
        {
            return (Sanctuaire) getZone(coordSanctBleu);
        }
        if (c == Couleur.ROUGE)
        {
            return (Sanctuaire) getZone(coordSanctRouge);
        }
        return null;
    }

    private ArrayList<Zone> getVoisinesOf(int x, int y)
    {
        ArrayList<Zone> list = new ArrayList<>();
        list.add(this.getZone(x, y - 1));
        list.add(this.getZone(x + 1, y - 1));
        list.add(this.getZone(x + 1, y));
        list.add(this.getZone(x + 1, y + 1));
        list.add(this.getZone(x, y + 1));
        list.add(this.getZone(x - 1, y + 1));
        list.add(this.getZone(x - 1, y));
        list.add(this.getZone(x - 1, y - 1));
        return list;

    }

    public Equipe quiAGagne()
    {
        for (Zone z : getVoisinesOf(coordSanctBleu.getX(), coordSanctBleu.getY()))
        {
            if (z.persoALeGoal())
            {
                return z.getPerso().getEquipe();
            }
        }
        for (Zone z : getVoisinesOf(coordSanctRouge.getX(), coordSanctRouge.getY()))
        {
            if (z.persoALeGoal())
            {
                return z.getPerso().getEquipe();
            }
        }

        return null;
    }
}
