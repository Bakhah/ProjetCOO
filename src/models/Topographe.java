/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author bakhah
 */
public class Topographe extends Personnage
{
    TypeDeplacement typeDep;
    public Topographe(int equipe)
    {
        super(equipe);
        this.typeDep = TypeDeplacement.DIAGONALE;
    }
    
}
