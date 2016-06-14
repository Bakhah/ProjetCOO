/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import models.Bucheron;
import models.Couleur;
import models.Equipe;
import models.Piegeur;
import models.Renifleur;
import models.Topographe;

/**
 *
 * @author hourdinf
 */
public class JFrameSelectEquipe extends javax.swing.JFrame
{

    private Equipe equipe;

    /**
     * Creates new form JFrameSelectEquipe
     */
    public JFrameSelectEquipe()
    {

    }

    /**
     * Initialise les composants de cette frame
     *
     * @param e l'équipe de cette frame
     */
    public void init(Equipe e)
    {
        this.equipe = e;
        equipe.addPerso(new Topographe(equipe));
        equipe.addPerso(new Renifleur(equipe));
        equipe.addPerso(new Piegeur(equipe));
        equipe.addPerso(new Bucheron(equipe));
        initComponents();
    }

    /**
     * Retourne le bouton Confirmer
     *
     * @return le bouton Confirmer
     */
    public JButton getButtonConfirmer()
    {
        return this.confirmButton;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        topoSelect = new javax.swing.JButton();
        piegSelect = new javax.swing.JButton();
        ReniSelect = new javax.swing.JButton();
        buchSelect = new javax.swing.JButton();
        topoimg = new javax.swing.JLabel();
        selected2 = new javax.swing.JLabel();
        piegimg = new javax.swing.JLabel();
        buchimg = new javax.swing.JLabel();
        selected1 = new javax.swing.JLabel();
        reniimg = new javax.swing.JLabel();
        selected3 = new javax.swing.JLabel();
        selected4 = new javax.swing.JLabel();
        selected5 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        botOn = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Droid Sans Mono", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Composez votre équipe : ");

        topoSelect.setText("Topographe");
        topoSelect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                topoSelectActionPerformed(evt);
            }
        });

        piegSelect.setText("Piégeur");
        piegSelect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                piegSelectActionPerformed(evt);
            }
        });

        ReniSelect.setText("Renifleur");
        ReniSelect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ReniSelectActionPerformed(evt);
            }
        });

        buchSelect.setText("Bûcheron");
        buchSelect.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buchSelectActionPerformed(evt);
            }
        });

        ImageIcon topoII;
        if (equipe.getCouleur() == Couleur.BLEU)
        topoII = new javax.swing.ImageIcon(getClass().getResource("/img/topobleu.png"));
        else
        topoII = new javax.swing.ImageIcon(getClass().getResource("/img/toporouge.png"));
        topoimg.setIcon(topoII);
        topoimg.setMaximumSize(new java.awt.Dimension(50, 15));
        topoimg.setMinimumSize(new java.awt.Dimension(50, 15));

        selected2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selected2.setMaximumSize(new java.awt.Dimension(50, 15));
        selected2.setMinimumSize(new java.awt.Dimension(50, 15));

        ImageIcon piegII;
        if (equipe.getCouleur() == Couleur.BLEU)
        piegII = new javax.swing.ImageIcon(getClass().getResource("/img/piegbleu.png"));
        else
        piegII = new javax.swing.ImageIcon(getClass().getResource("/img/piegrouge.png"));
        piegimg.setIcon(piegII);
        piegimg.setMaximumSize(new java.awt.Dimension(50, 15));
        piegimg.setMinimumSize(new java.awt.Dimension(50, 15));

        ImageIcon buchII;
        if (equipe.getCouleur() == Couleur.BLEU)
        buchII = new javax.swing.ImageIcon(getClass().getResource("/img/buchbleu.png"));
        else
        buchII = new javax.swing.ImageIcon(getClass().getResource("/img/buchrouge.png"));
        buchimg.setIcon(buchII);
        buchimg.setMaximumSize(new java.awt.Dimension(50, 15));
        buchimg.setMinimumSize(new java.awt.Dimension(50, 15));

        selected1.setIcon(topoimg.getIcon());
        selected1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selected1.setMaximumSize(new java.awt.Dimension(50, 15));
        selected1.setMinimumSize(new java.awt.Dimension(50, 15));

        ImageIcon reniII;
        if (equipe.getCouleur() == Couleur.BLEU)
        reniII = new javax.swing.ImageIcon(getClass().getResource("/img/renibleu.png"));
        else
        reniII = new javax.swing.ImageIcon(getClass().getResource("/img/renirouge.png"));
        reniimg.setIcon(reniII);
        reniimg.setMaximumSize(new java.awt.Dimension(50, 15));
        reniimg.setMinimumSize(new java.awt.Dimension(50, 15));

        selected3.setIcon(piegimg.getIcon());
        selected3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selected3.setMaximumSize(new java.awt.Dimension(50, 15));
        selected3.setMinimumSize(new java.awt.Dimension(50, 15));

        selected4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selected4.setIcon(buchimg.getIcon());
        selected4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selected4.setMaximumSize(new java.awt.Dimension(50, 15));
        selected4.setMinimumSize(new java.awt.Dimension(50, 15));

        selected5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selected5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selected5.setMaximumSize(new java.awt.Dimension(50, 15));
        selected5.setMinimumSize(new java.awt.Dimension(50, 15));
        selected5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                removePerso5(evt);
            }
        });

        confirmButton.setText("Confirmer");
        confirmButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                confirmButtonActionPerformed(evt);
            }
        });

        botOn.setText("IA");
        botOn.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                botOnItemStateChanged(evt);
            }
        });
        botOn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botOnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(botOn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(buchSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(piegSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ReniSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(topoSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(piegimg, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(topoimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buchimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reniimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selected1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selected2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selected3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selected4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selected5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botOn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topoSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(topoimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selected5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selected4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selected3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selected2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selected1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reniimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ReniSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(piegSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(piegimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buchimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buchSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        selected2.setIcon(reniimg.getIcon());
        confirmButton.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReniSelectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ReniSelectActionPerformed
    {//GEN-HEADEREND:event_ReniSelectActionPerformed

        selected5.setIcon(reniimg.getIcon());
        if (this.equipe.getListePerso().size() == 5)
        {
            this.equipe.getListePerso().remove(4);
        }
        this.equipe.addPerso(new Renifleur(equipe));
        confirmButton.setVisible(true);

    }//GEN-LAST:event_ReniSelectActionPerformed

    private void topoSelectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_topoSelectActionPerformed
    {//GEN-HEADEREND:event_topoSelectActionPerformed

        selected5.setIcon(topoimg.getIcon());
        if (this.equipe.getListePerso().size() == 5)
        {
            this.equipe.getListePerso().remove(4);
        }
        this.equipe.addPerso(new Topographe(equipe));
        confirmButton.setVisible(true);

    }//GEN-LAST:event_topoSelectActionPerformed

    private void piegSelectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_piegSelectActionPerformed
    {//GEN-HEADEREND:event_piegSelectActionPerformed

        selected5.setIcon(piegimg.getIcon());
        if (this.equipe.getListePerso().size() == 5)
        {
            this.equipe.getListePerso().remove(4);
        }
        this.equipe.addPerso(new Piegeur(equipe));
        confirmButton.setVisible(true);

    }//GEN-LAST:event_piegSelectActionPerformed

    private void buchSelectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buchSelectActionPerformed
    {//GEN-HEADEREND:event_buchSelectActionPerformed

        selected5.setIcon(buchimg.getIcon());
        if (this.equipe.getListePerso().size() == 5)
        {
            this.equipe.getListePerso().remove(4);
        }
        this.equipe.addPerso(new Bucheron(equipe));
        confirmButton.setVisible(true);

    }//GEN-LAST:event_buchSelectActionPerformed

    private void removePerso5(java.awt.event.MouseEvent evt)//GEN-FIRST:event_removePerso5
    {//GEN-HEADEREND:event_removePerso5
        if (selected5.getIcon() != null)
        {
            this.selected5.setIcon(null);
            confirmButton.setVisible(false);
            if (this.equipe.getListePerso().size() == 5)
            {
                this.equipe.getListePerso().remove(4);
            }
        }
    }//GEN-LAST:event_removePerso5

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_confirmButtonActionPerformed
    {//GEN-HEADEREND:event_confirmButtonActionPerformed
        dispose();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void botOnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botOnActionPerformed
    {//GEN-HEADEREND:event_botOnActionPerformed
        
    }//GEN-LAST:event_botOnActionPerformed

    private void botOnItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_botOnItemStateChanged
    {//GEN-HEADEREND:event_botOnItemStateChanged
        if (this.botOn.isSelected())
        {
            this.equipe.setBot(true);
        }
        else
        {
            this.equipe.setBot(false);
        }
    }//GEN-LAST:event_botOnItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReniSelect;
    private javax.swing.JCheckBox botOn;
    private javax.swing.JButton buchSelect;
    private javax.swing.JLabel buchimg;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton piegSelect;
    private javax.swing.JLabel piegimg;
    private javax.swing.JLabel reniimg;
    private javax.swing.JLabel selected1;
    private javax.swing.JLabel selected2;
    private javax.swing.JLabel selected3;
    private javax.swing.JLabel selected4;
    private javax.swing.JLabel selected5;
    private javax.swing.JButton topoSelect;
    private javax.swing.JLabel topoimg;
    // End of variables declaration//GEN-END:variables
}
