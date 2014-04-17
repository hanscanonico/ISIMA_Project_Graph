/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Map;
import javax.swing.BorderFactory;


/**
 *
 * @author Hans
 */
public class VueCentre extends javax.swing.JPanel {
// Map de iconesSommets avec pour clé les noms des sommets

    private Map<String, IconeSommet> lesIconesSommets;
// Map de iconeArrete avec pour clé la concatéantion du nom des 2 sommets de chaque extrémité
    private Map<String, IconeArrete> lesArretes;

    /**
     * Constructeur
     *
     * @param ctrl le cotnroleur
     * @param lesIconesSommets
     * @param lesArretes
     */
    public VueCentre(Controleur ctrl, Map<String, IconeSommet> lesSommets, Map<String, IconeArrete> lesArretes) {
        


        setBackground(Color.white);

        addMouseListener(ctrl);
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        setLayout(null);

        this.lesIconesSommets = lesSommets;
        this.lesArretes = lesArretes;
    }

    /**
     * Trace des sommets
     *
     * @param lesSommets
     * @param lesIconesSommets
     * @param g2
     */
    public void tracerSommets(Map<String, IconeSommet> lesSommets, Graphics2D g2) {

        int t = IconeSommet.taille;


        for (Map.Entry<String, IconeSommet> entry : lesSommets.entrySet()) {
            String nomSommet = entry.getKey();
            IconeSommet som = entry.getValue();



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

        lesIconesSommets.put(nomSommet, icoS);
        add(icoS);
        icoS.setBounds(new Rectangle((int) x, (int) y, 20, 45));
        icoS.validate();
        icoS.requestFocus();
        icoS.getTextField().validate();
        icoS.getTextField().requestFocus();

        repaint();

    }



    void ajouterArrete(IconeArrete nouv) {
        
        nouv.setLocation(new Point(10, 10));
        nouv.setBounds(0, 0, 500, 500);

        add(nouv);
        repaint();
    }
    



}
