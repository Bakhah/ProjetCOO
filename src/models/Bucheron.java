/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Image;

/**
 *
 * @author Louis
 */
public class Bucheron extends Personnage{

    public Bucheron(Equipe equipe) {
        super(equipe);
        super.setTypeDep(TypeDeplacement.CROIX);
    }

    @Override
    public Image getIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return "Bucheron";
    }
}
