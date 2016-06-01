/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author bakhah
 */
public class Monde
{
    private Zone[][] tabZone;
    private int largeur;
    private int hauteur;
    private Coordonnees coordSanctBleu;
    private Coordonnees coordSanctRouge;
    
    /**
     * instancie un monde de x zones de large sur Y zones de hauteur 
     */
    public Monde(int largeur, int hauteur){
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.coordSanctBleu=new Coordonnees(1,hauteur/2);
        this.coordSanctRouge=new Coordonnees(largeur-2,hauteur/2);
        this.tabZone = new Zone [largeur][hauteur];
        this.setFtrontiere();
        this.generateTerrain();
        this.setTheGoal();
        //this.placeSanctuarys();
        //TO-DO
    }
    
    public Zone getZone(int x, int y){
        return this.tabZone[x][y];
    }
    public Zone getZone(Coordonnees coordonnees){
        return this.tabZone[coordonnees.getX()][coordonnees.getY()];
    }
    /**
     * Retourn la largeur x du monde 
     * @return int
     */
    public int getLargeur(){
        return this.tabZone.length;
    }
    /**
     * Retourne la hauteur y du monde 
     * @return int
     */
    public int getHauteur(){
        return this.tabZone[0].length;
    }
    public boolean zoneExist(int x,int y){
        return x >= 0 && x < this.getLargeur() && y >= 0 && y < this.getHauteur();
    }
    private void setFtrontiere(){
        //Bordure NORD
        for (int i = 0; i<this.largeur;i++){
            this.tabZone[i][0]= new Frontiere();
        }
        //Bordure SUD
        for (int i = 0; i<this.largeur;i++){
            this.tabZone[i][hauteur-1]= new Frontiere();
        }
        //Bordure OUEST
        for (int i = 1; i<this.hauteur-1;i++){
            this.tabZone[0][i]= new Frontiere();
        }
        //Bordure EST
        for (int i = 1; i<this.hauteur-1;i++){
            this.tabZone[largeur-1][i]= new Frontiere();
        }
        
    }
    private void generateTerrain(){
        //Ne pas réecrir sur les frontières
        for(int i=1; i< largeur-1 ; i++){
            for(int j=1; j< hauteur-1;j++){
                //System.out.println(i + " " + j);
                this.tabZone[i][j]= generateRadomZone();
            }
        }
    }
    private Zone generateRadomZone(){ 
        Random r = new Random();
        int rand = r.nextInt(100);
        if(rand<5){
            return new Parcelle(Etat.ROCHE);
        }else if(rand<10){
            return new Parcelle(Etat.TROU);
        }else if(rand<20){
            return new Parcelle(Etat.TAS);
        }else if(rand<30){
            return new Parcelle(Etat.ARBRE);
        }else{
            return new Parcelle(Etat.VIDE);
        }
    }
    public void placeSanctuarys(Sanctuaire sanctuaireBleu,Sanctuaire sanctuaireRouge){
        this.tabZone[coordSanctBleu.getX()][coordSanctBleu.getY()]= sanctuaireBleu;
        this.tabZone[coordSanctRouge.getX()][coordSanctRouge.getY()]= sanctuaireRouge;
    }
    // METHODES POUR LE PLACEMENT DU GOAL
    //      GENERER UNE LISTE DE CASES ACCESSIBLES PAR LES 2 SANCTUAIRES
    //      PLACER LE GOAL AU HASARD DANS UNE DE CES CASES
    /**
     * Renvoie une liste de toutes les zones accessibles depuis la zone aux coordonnées xy
     * @param x abscisses
     * @param y ordonnées
     * @return 
     */
    public LinkedList<Coordonnees> getZonesAccessiblesDepuis(Coordonnees c){
        LinkedList<Coordonnees>listVerte=new LinkedList<>();
        listVerte.add(c);
        for(int i = 0 ; i< listVerte.size();i++){
            System.out.println("Taille de la liste : "+listVerte.size());
            System.out.println("Les voisins de "+listVerte.get(i)+" : "+ this.getCoordVoisinesDe(listVerte.get(i).getX(), listVerte.get(i).getY()));
            for(Coordonnees voisine : this.getCoordVoisinesDe(listVerte.get(i).getX(), listVerte.get(i).getY())){
                if(!listVerte.contains(voisine) && this.zoneVivable(voisine)){
                    listVerte.add(voisine);
                     System.out.println("Ajout de la Coordonnée : "+voisine); 
                }else{
                    System.out.println("Refus : "+voisine +""+"nouveau : "+!listVerte.contains(voisine)+" "+"Vivable :"+this.zoneVivable(voisine));
                }
            }
            System.out.println("Liste : "+listVerte);
        }
        return listVerte;
    }
    private ArrayList<Coordonnees>getListAccessibleDesDeuxSanctuaire(){
        ArrayList<Coordonnees>list =new ArrayList<>();
        LinkedList<Coordonnees>listBleu  = this.getZonesAccessiblesDepuis(coordSanctBleu);
        LinkedList<Coordonnees>listRouge = this.getZonesAccessiblesDepuis(coordSanctRouge);
        for(Coordonnees c : listBleu){
            if(listRouge.contains(c))list.add(c);
        }
        return list;
    }
    private void setTheGoal(){
        ArrayList<Coordonnees> list = this.getListAccessibleDesDeuxSanctuaire();
        Random r = new Random();
        int rand = r.nextInt(list.size()-1);
        this.tabZone[list.get(rand).getX()][list.get(rand).getY()].setItem(Item.GOAL);
    }
    private boolean zoneExists(int x, int y){
        return x<largeur-1 && x>1 && y<hauteur-1 && y>1;
    }
    public boolean zoneVivable(Coordonnees c){
        return !this.getZone(c).getEtat().equals(Etat.ROCHE);
    }
    public ArrayList<Coordonnees> getCoordVoisinesDe(int x, int y){
        ArrayList<Coordonnees>list=new ArrayList<>();
        if(this.zoneExist(x  , y-1))list.add(new Coordonnees(x  ,y-1));
        if(this.zoneExist(x  , y+1))list.add(new Coordonnees(x  ,y+1));
        if(this.zoneExist(x-1, y  ))list.add(new Coordonnees(x-1,y  ));
        if(this.zoneExist(x+1, y  ))list.add(new Coordonnees(x+1,y  ));
        return list;
    }
    
    public String toString(){
        String s="";
        for(int h=0;h<hauteur;h++){
            for(int l=0;l<largeur;l++){
                s+=this.tabZone[l][h].getEtat()+" ";
            }
            s+='\n';
        }
        return s;
    }
}
