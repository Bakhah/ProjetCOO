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
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import models.Couleur;
import models.Etat;
import models.Frontiere;
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

    static Image background = Toolkit.getDefaultToolkit().createImage("src/img/bg.png");
    static Image toporouge = Toolkit.getDefaultToolkit().createImage("src/img/toporouge.png");
    static Image topobleu = Toolkit.getDefaultToolkit().createImage("src/img/topobleu.png");
    static Image renirouge = Toolkit.getDefaultToolkit().createImage("src/img/renirouge.png");
    static Image renibleu = Toolkit.getDefaultToolkit().createImage("src/img/renibleu.png");
    static Image piegrouge = Toolkit.getDefaultToolkit().createImage("src/img/piegrouge.png");
    static Image piegbleu = Toolkit.getDefaultToolkit().createImage("src/img/piegbleu.png");

    static Image rock = Toolkit.getDefaultToolkit().createImage("src/img/rock.png");
    static Image arbre = Toolkit.getDefaultToolkit().createImage("src/img/arbre.png");
    static Image sanctubleu = Toolkit.getDefaultToolkit().createImage("src/img/sanctubleu.png");
    static Image sancturouge = Toolkit.getDefaultToolkit().createImage("src/img/sancturouge.png");
    static Image tas = Toolkit.getDefaultToolkit().createImage("src/img/tas.png");
    static Image trou = Toolkit.getDefaultToolkit().createImage("src/img/trou.png");
    static Image invisible = Toolkit.getDefaultToolkit().createImage("src/img/invisible.png");
    static Image fog = Toolkit.getDefaultToolkit().createImage("src/img/fog.png");
    static Image border = Toolkit.getDefaultToolkit().createImage("src/img/border.png");

    /**
     * Constructeur pour TESTER
     *
     */
    public Vue() //Constructeur test
    {

        //zone = new Parcelle(Etat.VIDE);
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
        if (this.zone instanceof Frontiere)
        {
            this.visible = true;
        }
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
        if (b)
        {
            this.isFog = false;
        }
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
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
        paintBackground(g);
        paintPersos(g);

        if (isFog)
        {
            g.drawImage(fog, 0, 0, this.getWidth(), this.getHeight(), null);
        }
        if (visible == false)
        {
            g.drawImage(invisible, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        if (highlight)
        {
            g.drawImage(border, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    private void paintBackground(Graphics g)
    {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
        if (this.zone.getEtat() != Etat.VIDE)
        {
            if (this.zone.getEtat() == Etat.ARBRE)
            {
                g.drawImage(arbre, 0, 0, this.getWidth(), this.getHeight(), null);
            }
            if (this.zone.getEtat() == Etat.TROU)
            {
                g.drawImage(trou, 0, 0, this.getWidth(), this.getHeight(), null);
            }
            if (this.zone.getEtat() == Etat.ROCHE)
            {
                g.drawImage(rock, 0, 0, this.getWidth(), this.getHeight(), null);
            }
            if (this.zone.getEtat() == Etat.TAS)
            {
                g.drawImage(tas, 0, 0, this.getWidth(), this.getHeight(), null);
            }

        }
    }

    private void paintPersos(Graphics g)
    {
        if (this.zone.contientPerso())
        {
            if (this.zone.getPerso().getCouleur() == Couleur.ROUGE)
            {
                if (this.zone.getPerso() instanceof Topographe)
                {
                    g.drawImage(toporouge, 0, 0, this.getWidth(), this.getHeight(), null);
                }
                if (this.zone.getPerso() instanceof Piegeur)
                {
                    g.drawImage(piegrouge, 0, 0, this.getWidth(), this.getHeight(), null);
                }
                if (this.zone.getPerso() instanceof Renifleur)
                {
                    g.drawImage(renirouge, 0, 0, this.getWidth(), this.getHeight(), null);
                }
            }
            if (this.zone.getPerso().getCouleur() == Couleur.BLEU)
            {
                if (this.zone.getPerso() instanceof Topographe)
                {
                    g.drawImage(topobleu, 0, 0, this.getWidth(), this.getHeight(), null);
                }
                if (this.zone.getPerso() instanceof Piegeur)
                {
                    g.drawImage(piegbleu, 0, 0, this.getWidth(), this.getHeight(), null);
                }
                if (this.zone.getPerso() instanceof Renifleur)
                {
                    g.drawImage(renibleu, 0, 0, this.getWidth(), this.getHeight(), null);
                }
            }
        }
    }

}
