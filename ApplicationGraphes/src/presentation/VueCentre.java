/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
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
    private Map<String, IconeArrete> lesIconesArretes;
    private ArreteTemporaire arrTemp;

    /**
     * Constructeur
     *
     * @param ctrl le cotnroleur
     * @param lesSommets
     * @param lesIconesArretes
     */
    public VueCentre(Controleur ctrl, Map<String, IconeSommet> lesSommets, Map<String, IconeArrete> lesArretes) {
        setBackground(Color.white);

        addMouseListener(ctrl);
        addMouseMotionListener(ctrl);

        arrTemp = new ArreteTemporaire();
        add(arrTemp);


        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        setLayout(null);

        this.lesIconesSommets = lesSommets;
        this.lesIconesArretes = lesArretes;
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
        int bnds = IconeSommet.taille;
        double[] pos = new double[]{x / getWidth(), y / getHeight()};
        IconeSommet icoS = new IconeSommet(ctrl, pos, (int) x, (int) y, nomSommet);

        lesIconesSommets.put(nomSommet, icoS);
        add(icoS);

        icoS.setBounds(new Rectangle((int) x, (int) y, bnds+1, bnds+1));
        icoS.validate();
        icoS.requestFocus();
        icoS.getTextField().validate();
        icoS.getTextField().requestFocus();

        repaint();

    }

    /**
     * Permet d'ajouter une arrête
     *
     * @param nouv la nouvelle arrête
     */
    void ajouterArrete(IconeArrete nouv) {

        nouv.setLocation(new Point(0, 0));
        nouv.setBounds(0, 0, getWidth(), getHeight());

        add(nouv);
        repaint();
    }

    void afficherArreteTemp(int x1, int y1, int x2, int y2) {
        add(arrTemp);
        arrTemp.setBounds(0, 0, getWidth(), getHeight());
        arrTemp.setX1(x1);
        arrTemp.setX2(x2);
        arrTemp.setY2(y2);
        arrTemp.setY1(y1);
        arrTemp.validate();
        repaint();
    }

    void masquerArreteTemp() {
        remove(arrTemp);
        repaint();
    }

    void deplacerSommet(double x, double y, String nom) {
        IconeSommet tmp = lesIconesSommets.get(nom);
        double[] pos = new double[]{x / getWidth(), y / getHeight()};
        tmp.setLocation(new Point((int)x, (int)y));
        tmp.setOrigineX((int)x);
        tmp.setOrigineY((int)y);
        repaint();
    }
}
