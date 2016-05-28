/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.ArrayList;
import models.Monde;
import models.Zone;

/**
 *
 * @author Louis
 */
public class Reboucher extends Action{

    public Reboucher(Monde mondeDuJeu) {
        super(mondeDuJeu);
    }

    @Override
    public boolean isPossible(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Zone> getZonePossible(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isZonePossible(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
