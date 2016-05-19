/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import models.Etat;
import models.Parcelle;
import models.Zone;

/**
 *
 * @author bakhah
 */
public class Vue
{

    private Zone zone;
    private boolean isFog;
    private boolean isVisible;

    public Vue() //Constructeur test
    {
        zone = new Parcelle(Etat.VIDE);
        isFog = false;
        isVisible = true;
    }
    
    public void setZone(Zone zone)
    {
        this.zone = zone;
    }
    public void setVisible(boolean b)
    {
        this.isVisible = b;
    }
    public void setFog(boolean b)
    {
        this.isFog = b;
    }
    
    @Override
    public String toString() //Affiche une version txt de la Vue
    {
        String res = new String();
        return zone.getEtat().toString();
    }
}
