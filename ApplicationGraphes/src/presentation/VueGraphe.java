/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import coucheApplicative.Modele;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import metier.Arrete;
import metier.Graphe;
import metier.IConstantes;
import metier.Sommet;

/**
 *
 * @author Hans
 */
public class VueGraphe extends JPanel implements IConstantes, Observer {

    private metier.Graphe g;
    private Set<IconeArrete> icoArr = new HashSet();
    private Set<IconeSommet> icoSomm = new HashSet();
    private Map<Sommet, IconeSommet> icoSom = new HashMap<>();
    private Modele mdl;
    private Controleur ctrl;
    private VueBas vueBas;

    /**
     *
     * @param g
     */
    public VueGraphe(Graphe g) {
        setLayout(new BorderLayout());
        this.g = g;
        
        generationDesIcones();
        randomPosition();
        
        JPanel vueCentre = new VueCentre(g, icoArr, icoSomm);
        JPanel vueGauche = new VueGauche();
        JPanel vueBas = new VueBas(ctrl);

        mdl = new Modele();
        mdl.addObserver(this);
        ctrl = new Controleur(mdl);

        add(vueCentre, BorderLayout.CENTER);
        add(vueGauche, BorderLayout.WEST);
        add(panneauBas(), BorderLayout.SOUTH);

        /*
        
        
         calculPosition();
         calculPosition2();
         for (IconeSommet icoS : icoSomm) {
         IconeSommet object = icoS;
         System.out.println(object.getDisp()[0]);
         }

         calculPosition();
       
         */

        this.setVisible(true);

    }

    private void randomPosition() {
        double temp;
        for (IconeSommet ico : icoSomm) {
            IconeSommet som = ico;
            temp = (Math.random() );
            som.getPos()[0] = temp;
            temp =  (Math.random() );
            som.getPos()[1] = temp;

        }

    }

    private void generationDesIcones() {
        Arrete arr;
        Sommet som;
        IconeArrete newIcoArr;
        IconeSommet newIcosom1;
        IconeSommet newIcosom2;

        for (Sommet s : g.getLesSommets()) {
            som = s;
            newIcosom1 = new IconeSommet(som);
            this.icoSomm.add(newIcosom1);
            this.icoSom.put(som, newIcosom1);
        }
        for (Arrete a : g.getLesArretes()) {
            arr = a;
            newIcosom1 = icoSom.get(arr.getSommet1());
            newIcosom2 = icoSom.get((arr.getSommet2()));

            newIcoArr = new IconeArrete(newIcosom1, newIcosom2);
            this.icoArr.add(newIcoArr);
        }


    }

    private void calculPosition2() {
        double area = getHeight() * getWidth();
        double k = Math.sqrt(area / icoSomm.size());
        double[] delta = new double[2];
        double[] temp = new double[2];

        for (IconeSommet icoS1 : icoSomm) {
            IconeSommet v = icoS1;
            for (IconeSommet icoS2 : icoSomm) {
                IconeSommet u = icoS2;
                if (v != u) {
                    delta[0] = v.getPos()[0] - u.getPos()[0];
                    delta[1] = v.getPos()[1] - u.getPos()[1];
                }
            }

        }
    }

    private double fonctionA(double z, double k) {
        double temp;
        temp = z * z / k;
        return temp;

    }

    private double fonctionR(double z, double k) {
        double temp;
        temp = k * k / z;

        return temp;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 102, 102));

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
    @Override
    public void update(Observable objetObserve, Object uneInformation) {
        if (objetObserve instanceof Modele) {
            if (uneInformation.toString().equals(MODE_SOMMET)) {
                Cursor curseur = new Cursor(Cursor.TEXT_CURSOR);
                this.setCursor(curseur);

            } else if (uneInformation.toString().equals(MODE_ARRETE)) {
                Cursor curseur = new Cursor(Cursor.CROSSHAIR_CURSOR);
                this.setCursor(curseur);

            } else if (uneInformation.toString().equals(MODE_FLECHE)) {
                Cursor curseur = new Cursor(Cursor.DEFAULT_CURSOR);
                this.setCursor(curseur);

            }
        }
    }

    private Component panneauBas() {
        vueBas = new VueBas(ctrl);
        return vueBas;
    }
}
