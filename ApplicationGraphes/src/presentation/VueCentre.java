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
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import metier.Graphe;

/**
 *
 * @author Hans
 */
public class VueCentre extends javax.swing.JPanel {
// Map de iconesSommets avec pour clé les noms des sommets

    private Map<String, IconeSommet> lesSommets;
// Map de iconeArrete avec pour clé la concatéantion du nom des 2 sommets de chaque extrémité
    private Map<String, IconeArrete> lesArretes;

//    
//    public void paintComponent(Graphics g) {
//
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//
//        g2.setColor(Color.WHITE);
//        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
//        g2.setColor(Color.red);
//
//        // g.drawOval(50, 50, 50, 50);
//       // adaptationDesPositions(lesSommets);
//       /* tracerArretes(lesArretes,g2);
//        tracerSommets(lesSommets,g2);*/
//
//    }
    /**
     * Constructeur
     *
     * @param ctrl le cotnroleur
     * @param lesSommets
     * @param lesArretes
     */
    public VueCentre(Controleur ctrl, Map<String, IconeSommet> lesSommets, Map<String, IconeArrete> lesArretes) {

        setBackground(Color.white);


        addMouseListener(ctrl);
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        setLayout(null);






        this.lesSommets = lesSommets;
        this.lesArretes = lesArretes;
    }

    /**
     * Trace des composants
     *
     * @param g Ce qui permet de tracer
     */
    /*  public void paintComponent(Graphics g) {

     Graphics2D g2 = (Graphics2D) g;
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
     RenderingHints.VALUE_ANTIALIAS_ON);

     g2.setColor(Color.WHITE);
     g2.fillRect(0, 0, this.getWidth(), this.getHeight());
     g2.setColor(Color.red);

     // g.drawOval(50, 50, 50, 50);
     adaptationDesPositions();
     tracerArretes(g2);
     tracerSommets(g2);

     }*/
    /**
     * Trace des sommets
     *
     * @param lesSommets
     * @param g2
     */
    public void tracerSommets(Map<String, IconeSommet> lesSommets, Graphics2D g2) {

        int t = IconeSommet.taille;


        for (Map.Entry<String, IconeSommet> entry : lesSommets.entrySet()) {
            String nomSommet = entry.getKey();
            IconeSommet som = entry.getValue();


            // System.out.println(nomSommet+"position : "+som.getCentreX()+"  "+som.getCentreY() );
         /*   g2.setColor(Color.ORANGE);
             g2.fillOval(som.getOrigineX(), som.getOrigineY(), t, t);
             g2.setColor(Color.BLUE);
             // g2.drawChars(nomSommet.toCharArray(), 0, 1, som.getOrigineX() + t / 3, som.getOrigineY() + t / 2);
             g2.drawString(nomSommet, som.getOrigineX() + t / 3, som.getOrigineY() + t / 2);*/
        }

    }

    /**
     * Trace des arrêtes
     *
     * @param lesArretes
     * @param g2
     */
    public void tracerArretes(Map<String, IconeArrete> lesArretes, Graphics2D g2) {

        for (IconeArrete arr : lesArretes.values()) {
            g2.setColor(Color.BLUE);
            g2.drawLine(arr.getSom1().getCentreX(), arr.getSom1().getCentreY(), arr.getSom2().getCentreX(), arr.getSom2().getCentreY());
        }
    }

    /**
     * Permet d'adapter les positions
     *
     * @param lesSommets
     */
    public void adaptationDesPositions(Map<String, IconeSommet> lesSommets) {
        int x, y, t = IconeSommet.taille * 2;
        for (IconeSommet icoS : lesSommets.values()) {
            IconeSommet som = icoS;
            som.setOrigineX((int) (som.getPos()[0] * (getWidth())));
            som.setOrigineY((int) (som.getPos()[1] * (getHeight())));
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

    /**
     * Permet d'ajouter un sommet
     *
     * @param x coordonée x y coordonnée y
     */
    void ajouterSommet(String nomSommet, double x, double y, Controleur ctrl) {
        setLayout(null);
        double[] pos = new double[]{x / getWidth(), y / getHeight()};


        IconeSommet icoS = new IconeSommet(ctrl, pos, (int) x, (int) y, nomSommet);

        lesSommets.put(nomSommet, icoS);
        add(icoS);
        System.out.println(icoS.getLocation());
        icoS.setBounds(new Rectangle((int) x, (int) y, 50, 50));
        icoS.validate();
        icoS.getTextField().validate();
        icoS.getTextField().validate();
        icoS.getTextField().requestFocus();
        System.out.println(icoS.getTextField().getSize());
        System.out.println(icoS.getTextField().getLocation());
        /* SpringLayout sp=new SpringLayout();
        
        
        
         SpringLayout.Constraints labelCons =
         sp.getConstraints(icoS);
         labelCons.setX(Spring.constant((int)x));
         labelCons.setY(Spring.constant((int)y));
         */

        repaint();

    }
}
