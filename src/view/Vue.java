/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import models.Etat;
import models.Parcelle;
import models.Piegeur;
import models.Renifleur;
import models.Topographe;
import models.Zone;
import sun.java2d.pipe.DrawImage;

/**
 *
 * @author bakhah
 */
public class Vue extends JPanel
{

    private Zone zone;
    private boolean isFog;
    private boolean isVisible;
    Image background = Toolkit.getDefaultToolkit().createImage("img/bg.png");
    Image toporouge = Toolkit.getDefaultToolkit().createImage("img/toporouge.png");
    Image topobleu = Toolkit.getDefaultToolkit().createImage("img/topobleu.png");
    Image renirouge = Toolkit.getDefaultToolkit().createImage("img/renirouge.png");
    Image renibleu = Toolkit.getDefaultToolkit().createImage("img/renibleu.png");
    Image piegrouge = Toolkit.getDefaultToolkit().createImage("img/piegrouge.png");
    Image piegbleu = Toolkit.getDefaultToolkit().createImage("img/piegbleu.png");
    
    Image rock = Toolkit.getDefaultToolkit().createImage("img/rock.png");
    Image arbre = Toolkit.getDefaultToolkit().createImage("img/arbre.png");
    Image sanctubleu = Toolkit.getDefaultToolkit().createImage("img/sanctubleu.png");
    Image sancturouge = Toolkit.getDefaultToolkit().createImage("img/sancturouge.png");
    Image tas = Toolkit.getDefaultToolkit().createImage("img/tas.png");
    Image trou = Toolkit.getDefaultToolkit().createImage("img/trou.png");
    
   
    

    public Vue() //Constructeur test
    {
        zone = new Parcelle(Etat.VIDE);
        isFog = false;
        isVisible = true;

        setBorder(BorderFactory.createLineBorder(Color.black));
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
        StringBuilder res = new StringBuilder();
        if (this.zone.getPerso() == null)
        {
            res.append("\033[0m");
        }
        else if (this.zone.getPerso().getEquipe() == 1)
            res.append("\033[31m");
        else
            res.append("\033[34m");
        
        res.append(this.zone.getEtat().toString());
        
        return res.toString();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(background, 0, 0, this);
        
        
        System.out.println("pouf");
        
        if (this.zone.getEtat() != Etat.VIDE)
        {
            if (this.zone.getEtat() == Etat.ARBRE)
                g.drawImage(arbre, 0, 0, null);
            if (this.zone.getEtat() == Etat.TROU)
                g.drawImage(trou, 0, 0, null);
            if (this.zone.getEtat() == Etat.ROCHE)
                g.drawImage(rock, 0, 0, null);
            if (this.zone.getEtat() == Etat.TAS)
                g.drawImage(tas, 0, 0, null);
            
        }
        
        if (this.zone.contientPerso())
        {
            if (this.zone.getPerso().getEquipe() == 1)
            {
                if (this.zone.getPerso() instanceof Topographe)
                    g.drawImage(toporouge, 0, 0, null);
                if (this.zone.getPerso() instanceof Piegeur)
                    g.drawImage(piegrouge, 0, 0, null);
                if (this.zone.getPerso() instanceof Renifleur)
                    g.drawImage(renirouge, 0, 0, null);
            }
            if (this.zone.getPerso().getEquipe() == 2)
            {
                if (this.zone.getPerso() instanceof Topographe)
                    g.drawImage(topobleu, 0, 0, null);
                if (this.zone.getPerso() instanceof Piegeur)
                    g.drawImage(piegbleu, 0, 0, null);
                if (this.zone.getPerso() instanceof Renifleur)
                    g.drawImage(renibleu, 0, 0, null);
            }
        }
    }
    
    
}
