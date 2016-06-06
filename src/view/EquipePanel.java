/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.EquipeButtonsListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import models.Equipe;
import models.Personnage;

/**
 *
 * @author hourdinf
 */
public final class EquipePanel extends javax.swing.JPanel
{

    private Equipe equipe;
    private VueJoueur vueJoueur;

    /**
     * Creates new form EquipePanel
     */
    public EquipePanel()
    {
        this.equipe = null;
        this.vueJoueur = null;
        
    } 
    public void setComponent(Equipe e, VueJoueur v)
    {
        initComponents();
        this.equipe = e;
        this.vueJoueur = v;
        jButton1.addActionListener(new EquipeButtonsListener(this.vueJoueur, equipe.getListePerso().get(0)));
        jButton2.addActionListener(new EquipeButtonsListener(this.vueJoueur, equipe.getListePerso().get(1)));
        jButton3.addActionListener(new EquipeButtonsListener(this.vueJoueur, equipe.getListePerso().get(2)));
        jButton4.addActionListener(new EquipeButtonsListener(this.vueJoueur, equipe.getListePerso().get(3)));
        jButton5.addActionListener(new EquipeButtonsListener(this.vueJoueur, equipe.getListePerso().get(4)));
    }

    public void refreshComponents() throws IOException
    {
        ArrayList<Personnage> list = equipe.getListePerso();

        jButton1.setIcon(new ImageIcon(list.get(0).getIcon()));
        jButton2.setIcon(new ImageIcon(list.get(1).getIcon()));
        jButton3.setIcon(new ImageIcon(list.get(2).getIcon()));
        jButton4.setIcon(new ImageIcon(list.get(3).getIcon()));
        jButton5.setIcon(new ImageIcon(list.get(4).getIcon()));

        jLabel1.setText(list.get(0).toString());
        jLabel2.setText(list.get(1).toString());
        jLabel3.setText(list.get(2).toString());
        jLabel4.setText(list.get(3).toString());
        jLabel5.setText(list.get(4).toString());

        if (!list.get(0).estVivant())
        {
            jButton1.setEnabled(false);
            jLabel1.setEnabled(false);
        }
        if (!list.get(1).estVivant())
        {
            jButton2.setEnabled(false);
            jLabel2.setEnabled(false);
        }
        if (!list.get(2).estVivant())
        {
            jButton3.setEnabled(false);
            jLabel3.setEnabled(false);
        }
        if (!list.get(3).estVivant())
        {
            jButton4.setEnabled(false);
            jLabel4.setEnabled(false);
        }
        if (!list.get(4).estVivant())
        {
            jButton5.setEnabled(false);
            jLabel5.setEnabled(false);
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Droid Sans Mono", 0, 12)); // NOI18N
        jLabel1.setText("perso1");

        jLabel2.setFont(new java.awt.Font("Droid Sans Mono", 0, 12)); // NOI18N
        jLabel2.setText("perso2");

        jLabel3.setFont(new java.awt.Font("Droid Sans Mono", 0, 12)); // NOI18N
        jLabel3.setText("perso3");

        jLabel4.setFont(new java.awt.Font("Droid Sans Mono", 0, 12)); // NOI18N
        jLabel4.setText("perso5");

        jLabel5.setFont(new java.awt.Font("Droid Sans Mono", 0, 12)); // NOI18N
        jLabel5.setText("perso4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
