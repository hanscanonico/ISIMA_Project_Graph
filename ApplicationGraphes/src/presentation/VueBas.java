/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import metier.IConstantes;

/**
 *
 * @author Hans
 */
public class VueBas extends JPanel implements IConstantes {

    /**
     * Constructeur
     *
     * @param ctrl
     */
    public VueBas(Controleur ctrl) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(500, getHeight()));
        center.add(new BoutonSommet(ctrl, "sommet", MODE_SOMMET), BorderLayout.WEST);
        center.add(new BoutonArrete(ctrl, "arrete", MODE_ARRETE), BorderLayout.CENTER);
        center.add(nouveauBoutton(ctrl, "fleche", MODE_FLECHE), BorderLayout.EAST);
        add(center, BorderLayout.CENTER);
        setPreferredSize(new Dimension(1100, 65));
    }

    /**
     * Permet de créer un nouveau boutton
     *
     * @param ctrl
     */
    private JButton nouveauBoutton(Controleur ctrl, String nom, String actionCommand) {
        JButton jb = new BasicArrowButton(SwingConstants.EAST);

        jb.setPreferredSize(new Dimension(150, 50));
        jb.setActionCommand(actionCommand);
        jb.addActionListener(ctrl);
        return jb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
