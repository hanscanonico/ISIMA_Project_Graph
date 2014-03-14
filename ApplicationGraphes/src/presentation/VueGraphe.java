/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import coucheApplicative.Modele;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
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
    private VueCentre vueCentre;

    /**
     *
     * @param g un graphe
     */
    public VueGraphe(Graphe g) {
        this();
        this.g = g;
        generationDesIcones();
        randomPosition();
    }

    /**
     *
     */
    public VueGraphe() {
        setLayout(new BorderLayout());
        JPanel vueGauche = new VueGauche();
        mdl = new Modele();
        mdl.addObserver(this);
        ctrl = new Controleur(mdl);
        add(panneauCentre(), BorderLayout.CENTER);
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

     /**
     *
     */
    private void randomPosition() {
        double temp;
        for (IconeSommet ico : icoSomm) {
            IconeSommet som = ico;
            temp = (Math.random());
            som.getPos()[0] = temp;
            temp = (Math.random());
            som.getPos()[1] = temp;

        }

    }

     /**
     *
     */
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
    
    /**
     *
     */
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
            String tabInfos[] = uneInformation.toString().split(SEPARATEUR);

            if (tabInfos[0].equals(MODE_SOMMET)) {
                modeSommet();
            } else if (tabInfos[0].equals(MODE_ARRETE)) {
                modeArrete();
            } else if (tabInfos[0].equals(MODE_FLECHE)) {
                modeFleche();
            } else if (tabInfos[0].equals(AJOUTER_SOMMET)) {
                int t = IconeSommet.taille * 2;
                double x = Double.parseDouble(tabInfos[1]);
                double y = Double.parseDouble(tabInfos[2]);
                Sommet nouv = new Sommet(" ", 0);
                g.ajouterSommet(nouv);
                generationDesIcones();
                this.icoSom.get(nouv).getPos()[0] = (x / vueCentre.getWidth());
                this.icoSom.get(nouv).getPos()[1] = (y / vueCentre.getHeight());
                vueCentre.repaint();
            }
        }
    }

    private Component panneauBas() {
        vueBas = new VueBas(ctrl);
        return vueBas;
    }

    private Component panneauCentre() {
        vueCentre = new VueCentre(g, icoArr, icoSomm, ctrl);
        return vueCentre;
    }

    private void modeSommet() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getBestCursorSize(48, 48);
        BufferedImage newImage = new BufferedImage(48, 48, BufferedImage.TYPE_INT_ARGB);

        Shape circle = new Ellipse2D.Double(0, 0, dim.width - 1, dim.height - 1);

        int centerX = (dim.width - 30) / 2;
        int centerY = (dim.height - 30) / 2;

        Graphics2D g = newImage.createGraphics();

        g.setColor(Color.ORANGE);
        g.fill(circle);

        Cursor customCursor = toolkit.createCustomCursor(newImage, new Point(centerX, centerY), "Cursor");
        this.setCursor(customCursor);

    }

    private void modeArrete() {
        Cursor curseur = new Cursor(Cursor.CROSSHAIR_CURSOR);
        this.setCursor(curseur);
    }

    private void modeFleche() {
        Cursor curseur = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(curseur);
    }
}
