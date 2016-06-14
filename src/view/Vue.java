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
import models.Bucheron;
import models.Couleur;
import models.Etat;
import models.Frontiere;
import models.Piegeur;
import models.Renifleur;
import models.Sanctuaire;
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
    private boolean affichageTxt;

    static Image background = Toolkit.getDefaultToolkit().createImage("src/img/bg.png");

    static Image toporouge = Toolkit.getDefaultToolkit().createImage("src/img/toporouge.png");
    static Image topobleu = Toolkit.getDefaultToolkit().createImage("src/img/topobleu.png");
    static Image renirouge = Toolkit.getDefaultToolkit().createImage("src/img/renirouge.png");
    static Image renibleu = Toolkit.getDefaultToolkit().createImage("src/img/renibleu.png");
    static Image piegrouge = Toolkit.getDefaultToolkit().createImage("src/img/piegrouge.png");
    static Image piegbleu = Toolkit.getDefaultToolkit().createImage("src/img/piegbleu.png");
    static Image buchrouge = Toolkit.getDefaultToolkit().createImage("src/img/buchrouge.png");
    static Image buchbleu = Toolkit.getDefaultToolkit().createImage("src/img/buchbleu.png");

    static Image ttoporouge = Toolkit.getDefaultToolkit().createImage("src/img/ttoporouge.png");
    static Image ttopobleu = Toolkit.getDefaultToolkit().createImage("src/img/ttopobleu.png");
    static Image trenirouge = Toolkit.getDefaultToolkit().createImage("src/img/trenirouge.png");
    static Image trenibleu = Toolkit.getDefaultToolkit().createImage("src/img/trenibleu.png");
    static Image tpiegrouge = Toolkit.getDefaultToolkit().createImage("src/img/tpiegrouge.png");
    static Image tpiegbleu = Toolkit.getDefaultToolkit().createImage("src/img/tpiegbleu.png");
    static Image tbuchrouge = Toolkit.getDefaultToolkit().createImage("src/img/tbuchrouge.png");
    static Image tbuchbleu = Toolkit.getDefaultToolkit().createImage("src/img/tbuchbleu.png");

    static Image goal = Toolkit.getDefaultToolkit().createImage("src/img/goal.png");
    static Image bgfouille = Toolkit.getDefaultToolkit().createImage("src/img/bgfouille.png");
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
        this.affichageTxt = false;
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
        this.affichageTxt = false;
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

    public String getTxt()
    {

        return (this.zone.getStringEtat() + " " + this.zone.getStringPerso());
    }

    public String getTxt2()
    {
        String foggy = new String();

        if (this.isFog)
        {
            foggy = "F";
        } else
        {
            foggy = " ";
        }
        return this.zone.getStringFouille() + " " + foggy;
    }

    public void setAffichageTxt()
    {
        if (affichageTxt)
        {
            this.affichageTxt = false;
            repaint();
        } else
        {
            this.affichageTxt = true;

        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.

        if (affichageTxt)
        {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            if (visible)
            {
                if (this.getZone().contientPerso())
                {
                    if (this.getZone().getPerso().getCouleur() == Couleur.BLEU)
                    {
                        g.setColor(Color.BLUE);
                    } else
                    {
                        g.setColor(Color.RED);
                    }
                }

                g.drawString(getTxt(), getWidth() / 3, getHeight() / 3);
                g.drawString(getTxt2(), getWidth() / 3, (getHeight() / 3) * 2);
            } else
            {
                g.drawString("    ", getWidth() / 3, getHeight() / 3);
                g.drawString("    ", getWidth() / 3, (getHeight() / 3) * 2);
            }
            setBorder(BorderFactory.createLineBorder(Color.BLACK));

            if (highlight)
            {
                g.drawImage(border, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        } else
        {
            paintBackground(g);
            setBorder(null);
            if (this.zone.contientGoal() && this.zone.isFouillee())
            {
                g.drawImage(goal, 0, 0, this.getWidth(), this.getHeight(), null);
            }
            paintPersos(g);
            paintSanctuaires(g);
            paintGoal(g);

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
    }

    private void paintBackground(Graphics g)
    {
        if (this.zone.isFouillee())
        {
            g.drawImage(bgfouille, 0, 0, this.getWidth(), this.getHeight(), this);
        } else
        {
            g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
        }
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
            if (this.zone.getPerso().peutEncoreJouer())
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
                    if (this.zone.getPerso() instanceof Bucheron)
                    {
                        g.drawImage(buchrouge, 0, 0, this.getWidth(), this.getHeight(), null);
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
                    if (this.zone.getPerso() instanceof Bucheron)
                    {
                        g.drawImage(buchbleu, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                }
            } else
            {
                if (this.zone.getPerso().getCouleur() == Couleur.ROUGE)
                {
                    if (this.zone.getPerso() instanceof Topographe)
                    {
                        g.drawImage(ttoporouge, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                    if (this.zone.getPerso() instanceof Piegeur)
                    {
                        g.drawImage(tpiegrouge, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                    if (this.zone.getPerso() instanceof Renifleur)
                    {
                        g.drawImage(trenirouge, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                    if (this.zone.getPerso() instanceof Bucheron)
                    {
                        g.drawImage(tbuchrouge, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                }
                if (this.zone.getPerso().getCouleur() == Couleur.BLEU)
                {
                    if (this.zone.getPerso() instanceof Topographe)
                    {
                        g.drawImage(ttopobleu, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                    if (this.zone.getPerso() instanceof Piegeur)
                    {
                        g.drawImage(tpiegbleu, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                    if (this.zone.getPerso() instanceof Renifleur)
                    {
                        g.drawImage(trenibleu, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                    if (this.zone.getPerso() instanceof Bucheron)
                    {
                        g.drawImage(tbuchbleu, 0, 0, this.getWidth(), this.getHeight(), null);
                    }
                }
            }
        }
    }

    private void paintSanctuaires(Graphics g)
    {
        if (this.zone instanceof Sanctuaire)
        {
            Sanctuaire s = (Sanctuaire) zone;
            if (s.getC() == Couleur.BLEU)
            {
                g.drawImage(sanctubleu, 0, 0, this.getWidth(), this.getHeight(), null);
            } else
            {
                g.drawImage(sancturouge, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }

    }

    private void paintGoal(Graphics g)
    {

        if (this.zone.contientPerso())
        {
            if (this.zone.getPerso().aLeGoal())
            {
                g.drawImage(goal, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }
    }

}
