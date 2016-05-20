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
import models.Etat;
import models.Parcelle;
import models.Piegeur;
import models.Renifleur;
import models.Topographe;
import models.Zone;

/**
 *
 * @author bakhah
 */
public class Vue extends JPanel
{

    private Zone zone;
    private boolean isFog;
    private boolean visible;
    private boolean highlight;

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
    Image invisible = Toolkit.getDefaultToolkit().createImage("img/invisible.png");
    Image fog = Toolkit.getDefaultToolkit().createImage("img/fog.png");
    Image border = Toolkit.getDefaultToolkit().createImage("img/border.png");

    public Vue() //Constructeur test
    {
        zone = new Parcelle(Etat.VIDE);
        isFog = true;
        visible = true;
        highlight = false;

        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    public void setZone(Zone zone)
    {
        this.zone = zone;
    }

  
    public void setVueVisible(boolean b)
    {
        this.visible = b;
    }

    public void setFog(boolean b)
    {
        this.isFog = b;
    }

    public void setHighlight(boolean b)
    {
        this.highlight = b;
    }

    
    public boolean setVueVisible()
    {
        return visible;
    }

    public boolean isFog()
    {
        return isFog;
    }

    public boolean isHighlighted()
    {
        return highlight;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        if (visible == false)
        {
            System.out.println("!!!");
            g.drawImage(invisible, 0, 0, this);
        } else
        {
            g.drawImage(background, 0, 0, this);
            if (this.zone.getEtat() != Etat.VIDE)
            {
                if (this.zone.getEtat() == Etat.ARBRE)
                {
                    g.drawImage(arbre, 0, 0, null);
                }
                if (this.zone.getEtat() == Etat.TROU)
                {
                    g.drawImage(trou, 0, 0, null);
                }
                if (this.zone.getEtat() == Etat.ROCHE)
                {
                    g.drawImage(rock, 0, 0, null);
                }
                if (this.zone.getEtat() == Etat.TAS)
                {
                    g.drawImage(tas, 0, 0, null);
                }

            }

            if (this.zone.contientPerso())
            {
                if (this.zone.getPerso().getEquipe() == 1)
                {
                    if (this.zone.getPerso() instanceof Topographe)
                    {
                        g.drawImage(toporouge, 0, 0, null);
                    }
                    if (this.zone.getPerso() instanceof Piegeur)
                    {
                        g.drawImage(piegrouge, 0, 0, null);
                    }
                    if (this.zone.getPerso() instanceof Renifleur)
                    {
                        g.drawImage(renirouge, 0, 0, null);
                    }
                }
                if (this.zone.getPerso().getEquipe() == 2)
                {
                    if (this.zone.getPerso() instanceof Topographe)
                    {
                        g.drawImage(topobleu, 0, 0, null);
                    }
                    if (this.zone.getPerso() instanceof Piegeur)
                    {
                        g.drawImage(piegbleu, 0, 0, null);
                    }
                    if (this.zone.getPerso() instanceof Renifleur)
                    {
                        g.drawImage(renibleu, 0, 0, null);
                    }
                }
            }
            if (isFog)
            {
                g.drawImage(fog, 0, 0, this);
            }
            if (highlight)
            {
                g.drawImage(border, 0, 0, this);
            }
        }
    }

}
