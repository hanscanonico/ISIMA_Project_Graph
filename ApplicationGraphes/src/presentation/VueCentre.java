/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Set;
import javax.swing.BorderFactory;
import metier.Graphe;

/**
 *
 * @author Hans
 */
public class VueCentre extends javax.swing.JPanel {

    private Graphe graphe;
    private Set<IconeArrete> icoArr;
    private Set<IconeSommet> icoSomm;

    /**
     *
     * @param graphe
     * @param icoArr
     * @param icoSomm
     */
    public VueCentre(Graphe graphe, Set icoArr, Set icoSomm) {

        setLayout(new BorderLayout());
        this.graphe = graphe;
        this.icoArr = icoArr;
        this.icoSomm = icoSomm;
        setBorder(BorderFactory.createLineBorder(Color.black, 1));

        setBackground(Color.white);


    }

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(Color.red);

        // g.drawOval(50, 50, 50, 50);

        tracerSommets(g2);
        tracerArretes(g2);


    }

    private void tracerSommets(Graphics2D g2) {

        for (IconeSommet icoS : icoSomm) {
            IconeSommet som = icoS;
            g2.setColor(Color.red);
            g2.drawOval((int) som.getPos()[1], (int) som.getPos()[0], 40, 40);
            g2.drawChars(som.getMonSommet().getNom().toCharArray(), 0, 1, (int) som.getPos()[1], (int) som.getPos()[0]);

        }

    }

    private void tracerArretes(Graphics2D g2) {

        for (IconeArrete icoA : icoArr) {
            IconeArrete arr = icoA;
            g2.setColor(Color.red);
            g2.drawLine((int) arr.getPos()[1] + 20, (int) arr.getSom1().getPos()[0] + 20, (int) arr.getSom2().getPos()[1] + 20, (int) arr.getSom2().getPos()[0] + 20);
            System.out.println(arr.getSom1().getPos()[1] + "-" + arr.getSom1().getPos()[0]);
            System.out.println(arr.getSom2().getPos()[1] + "-" + arr.getSom2().getPos()[0]);
            System.out.println();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
