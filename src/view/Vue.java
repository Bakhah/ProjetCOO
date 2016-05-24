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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    Image background = Toolkit.getDefaultToolkit().createImage("src/img/bg.png");
    Image toporouge = Toolkit.getDefaultToolkit().createImage("src/img/toporouge.png");
    Image topobleu = Toolkit.getDefaultToolkit().createImage("src/img/topobleu.png");
    Image renirouge = Toolkit.getDefaultToolkit().createImage("src/img/renirouge.png");
    Image renibleu = Toolkit.getDefaultToolkit().createImage("src/img/renibleu.png");
    Image piegrouge = Toolkit.getDefaultToolkit().createImage("src/img/piegrouge.png");
    Image piegbleu = Toolkit.getDefaultToolkit().createImage("src/img/piegbleu.png");

    Image rock = Toolkit.getDefaultToolkit().createImage("src/img/rock.png");
    Image arbre = Toolkit.getDefaultToolkit().createImage("src/img/arbre.png");
    Image sanctubleu = Toolkit.getDefaultToolkit().createImage("src/img/sanctubleu.png");
    Image sancturouge = Toolkit.getDefaultToolkit().createImage("src/img/sancturouge.png");
    Image tas = Toolkit.getDefaultToolkit().createImage("src/img/tas.png");
    Image trou = Toolkit.getDefaultToolkit().createImage("src/img/trou.png");
    Image invisible = Toolkit.getDefaultToolkit().createImage("src/img/invisible.png");
    Image fog = Toolkit.getDefaultToolkit().createImage("src/img/fog.png");
    Image border = Toolkit.getDefaultToolkit().createImage("src/img/border.png");

    /**
     * Constructeur pour TESTER
     *
     */
    public Vue() //Constructeur test
    {

        zone = new Parcelle(Etat.VIDE);
        isFog = false;
        visible = true;
        highlight = false;

        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    /**
     * Constructeur de Vue complet
     *
     * @param zone la zone
     * @param visible Vue visible ou invisible
     * @param fog Vue fog ou non
     * @param highlight Vue highlight ou non
     */
    public Vue(Zone zone, boolean visible, boolean fog, boolean highlight)
    {

        this.zone = zone;
        this.visible = visible;
        this.isFog = fog;
        this.highlight = highlight;
    }

    /**
     * Constructeur simplifié, instancie une vue avec une zone, invisible, non
     * fog, et non highlight
     *
     * @param zone la Zone
     */
    public Vue(Zone zone)
    {

        this.zone = zone;
        this.visible = false;
        this.isFog = false;
        this.highlight = false;
    }

    /**
     * Modifie la zone de la Vue
     *
     * @param zone une Zone
     */
    public void setZone(Zone zone)
    {
        this.zone = zone;
    }

    /**
     * Rend la Vue visible ou non
     *
     * @param b : boolean
     */
    public void setVueVisible(boolean b)
    {
        this.visible = b;
    }

    /**
     * Rend la vue fog ou non
     *
     * @param b : boolean
     */
    public void setFog(boolean b)
    {
        this.isFog = b;
    }

    /**
     * Rend la vue highlighted ou non
     *
     * @param b : boolean
     */
    public void setHighlight(boolean b)
    {
        this.highlight = b;
    }

    /**
     * Retourne si la Vue est "visible"
     *
     * @return boolean
     */
    public boolean isVueVisible()
    {
        return visible;
    }

    /**
     * Retourne si la vue est fog ou non
     *
     * @return boolean
     */
    public boolean isFog()
    {
        return isFog;
    }

    /**
     * Retourne si la vue est highlighted ou non
     *
     * @return boolean
     */
    public boolean isHighlighted()
    {
        return highlight;
    }
    public Zone getZone()
    {
        return this.zone;
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
