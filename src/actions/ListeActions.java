/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import java.util.ArrayList;
import models.Monde;

/**
 *
 * @author lalleaul
 */
public class ListeActions{
    private ArrayList<Action> listActions;
    public ListeActions(Monde monde){
        this.listActions=new ArrayList<>();
        this.listActions.add(new Deplacement(monde));
        this.listActions.add(new Creuser(monde));
        this.listActions.add(new Ramasser(monde));
        this.listActions.add(new Reboucher(monde));
    }
    public ArrayList<Action> getActionsPossible(int x, int y){
        ArrayList<Action> list = new ArrayList<>();
        for(Action a : listActions){
            if(a.isPossible(x, y))list.add(a);
        }
        return list;
    }
}
