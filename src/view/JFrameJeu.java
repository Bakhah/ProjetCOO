/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.FinTourListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Equipe;
import models.Monde;

/**
 *
 * @author bakhah
 */
public class JFrameJeu extends javax.swing.JFrame
{

    private final Equipe equipe;
    private final Monde monde;
    private JFrameJeu autreFrame;
    

    /**
     * Creates new form JFrameJeu
     *
     * @param equipe1 Première équipe
     * @param monde le Monde
     */
    public JFrameJeu(Equipe equipe1, Monde monde)
    {
        this.equipe = equipe1;
        this.monde = monde;
        initComponents();  
        myInit();
        LabelEquipe.setText("Equipe " + this.equipe.getCouleur());
        
        
    }
    public VueJoueur getVueJoueur()
    {
        return this.vueJoueur1;
    }
    public Equipe getEquipe()
    {
        return this.equipe;
    }
    public void setOtherFrame(JFrameJeu jf)
    {
        this.autreFrame = jf;
         this.FinTourButton.addActionListener(new FinTourListener(this, autreFrame));
    }
    private void myInit()
    {
        this.vueJoueur1.setComponent(equipe, monde);
        this.equipePanel1.setComponent(equipe, this.vueJoueur1);
        try
        {
            this.equipePanel1.refreshComponents();
        } catch (IOException ex)
        {
            Logger.getLogger(JFrameJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        ItemLabel = new javax.swing.JLabel();
        LabelEquipe = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        FinTourButton = new javax.swing.JButton();
        ItemPanel = new view.ItemPanel();
        equipePanel1 = new view.EquipePanel();
        vueJoueur1 = new VueJoueur();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ItemLabel.setBackground(new java.awt.Color(153, 153, 0));
        ItemLabel.setFont(new java.awt.Font("Droid Sans Mono", 1, 18)); // NOI18N
        ItemLabel.setText("Items :");
        getContentPane().add(ItemLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 150, 40));

        LabelEquipe.setBackground(new java.awt.Color(0, 153, 0));
        LabelEquipe.setFont(new java.awt.Font("Droid Sans Mono", 1, 18)); // NOI18N
        LabelEquipe.setText("Equipe Rouge");
        getContentPane().add(LabelEquipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 50));

        StatusLabel.setBackground(new java.awt.Color(0, 204, 204));
        StatusLabel.setFont(new java.awt.Font("Droid Sans Mono", 1, 14)); // NOI18N
        StatusLabel.setText("Ceci est la barre de status qui se met à jour bla bla bla bla bla lorem ipsum etc...");
        getContentPane().add(StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 650, 30));

        FinTourButton.setFont(new java.awt.Font("Droid Sans Mono", 1, 12)); // NOI18N
        FinTourButton.setText("Fin du tour");
        getContentPane().add(FinTourButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 180, 40));

        ItemPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(ItemPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 170, 410));
        getContentPane().add(equipePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 330));
        getContentPane().add(vueJoueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 500, 470));

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FinTourButton;
    private javax.swing.JLabel ItemLabel;
    private view.ItemPanel ItemPanel;
    private javax.swing.JLabel LabelEquipe;
    private javax.swing.JLabel StatusLabel;
    private view.EquipePanel equipePanel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private view.VueJoueur vueJoueur1;
    // End of variables declaration//GEN-END:variables
}
