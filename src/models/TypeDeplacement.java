/*
 * 2 types de deplacement :
 *  _x_      xxx
 *  xox      xox
 *  _x_      xxx
 * CROIX  DIAGONALE
 * 
 * 
 */
package models;

/**
 *
 * @author l0u15
 */
import java.util.ArrayList;

public enum TypeDeplacement
{

    /**
     * NORD OUEST X EST SUD
     *
     */
    CROIX("croix"),
    /**
     * NORD-OUEST NORD NORD-EST OUEST X EST SUD-OUEST SUD SUD-EST
     */
    DIAGONALE("diagonale");

    private String type;

    TypeDeplacement(String typeDeDeplacement)
    {
        this.type = typeDeDeplacement;
    }

    /**
     * retourne le type de déplacement
     *
     * @return croix || diagonale
     */
    public String getType()
    {
        return this.type;
    }

    public ArrayList<Coordonnees> getChoix(Coordonnees c)
    {
        return null;
    }

    public boolean equals(TypeDeplacement deplacement)
    {
        return this.type == deplacement.getType();
    }
}
