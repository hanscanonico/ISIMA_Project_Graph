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

//  le modele
    private Modele mdl;
//  le controleur
    private Controleur ctrl;
//  la vueBas
    private VueBas vueBas;
//  la vueCentre
    private VueGauche vueGauche;
//  la vueGauche
    private VueCentre vueCentre;
// Map de iconesSommets avec pour clé les noms des sommets
    private Map<String,IconeSommet> lesSommets;
// Map de iconeArrete avec pour clé la concatéantion du nom des 2 sommets de chaque extrémité
    private Map<String,IconeArrete> lesArretes;
    
    


    /**
     * Constructeur
     */
    public VueGraphe() {
        lesSommets=new HashMap();
        lesArretes=new HashMap();
        setLayout(new BorderLayout());
        mdl = new Modele();
        mdl.addObserver(this);
        ctrl = new Controleur(mdl);
        add(panneauCentre(), BorderLayout.CENTER);
        add(panneauGauche(), BorderLayout.WEST);
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
     * Place des sommets à des positions randoms
     */
    private void randomPosition() {
        double temp;
        for (IconeSommet ico : lesSommets.values()) {
            IconeSommet som = ico;
            temp = (Math.random());
            som.getPos()[0] = temp;
            temp = (Math.random());
            som.getPos()[1] = temp;

        }

    }

     /**
     * Génère des icones
     */
    private void generationDesIcones() {
      /*  Arrete arr;
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
        }*/
        
                lesSommets.clear();
                IconeSommet a = new IconeSommet();
                lesSommets.put("A", a);
                IconeSommet b = new IconeSommet();
                lesSommets.put("B", b);
                IconeSommet c = new IconeSommet();
                lesSommets.put("C", c);
                IconeSommet d = new IconeSommet();
                lesSommets.put("D", d);
                IconeSommet e = new IconeSommet();
                lesSommets.put("E", e);

                
                IconeArrete ab=new IconeArrete(a, b);
                lesArretes.put("AB", ab);
                IconeArrete ac=new IconeArrete(a, c);
                lesArretes.put("AC", ac);
                IconeArrete bc=new IconeArrete(b, c);
                lesArretes.put("BC", bc);
                IconeArrete ad=new IconeArrete(a, d);
                lesArretes.put("AD", ad);
                IconeArrete bd=new IconeArrete(b, d);
                lesArretes.put("BD", bd);
                IconeArrete cd=new IconeArrete(c, d);
                lesArretes.put("CD", bd);
                IconeArrete ae=new IconeArrete(a, e);
                lesArretes.put("AE", ae);
                IconeArrete be=new IconeArrete(b, e);
                lesArretes.put("BE", be);
                IconeArrete ce=new IconeArrete(c, e);
                lesArretes.put("CE",ce);
                IconeArrete de=new IconeArrete(d, e);
                lesArretes.put("DE", de);
    }
    
    /**
     * Calcul position
     */
    /*
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
*/
    /**
     * fonction A
     */
    private double fonctionA(double z, double k) {
        double temp;
        temp = z * z / k;
        return temp;

    }

    /**
     * fonction R
     */
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
    
    /**
     * Calcul position
     * @param objetObserve l'objet observé
     * @param uneInformation l'information
     */
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
                String nomSommet=tabInfos[3];
                
                
              /*  Sommet nouv = new Sommet(" ", 0);
                g.ajouterSommet(nouv);*/
                
                IconeSommet icoS=new IconeSommet();
                icoS.setPos(new double[]{x/vueCentre.getWidth(),y/vueCentre.getHeight()});
                lesSommets.put(nomSommet, icoS);
                //vueCentre.ajouterSommet(x, y,nomSommet);
                vueCentre.repaint();
                /*
                this.icoSom.get(nouv).getPos()[0] = (x / vueCentre.getWidth());
                this.icoSom.get(nouv).getPos()[1] = (y / vueCentre.getHeight());
                vueCentre.repaint();*/
            } else if (tabInfos[0].equals(GENERER)) {
                genererGraphe();
                
            }
        }
    }

    /**
     * génère un graphe 
     */
    public void genererGraphe()
    {
        generationDesIcones();
        randomPosition();
        vueCentre.repaint();
    }
    
     /**
     * Crée le panneau du bas 
     */
    private Component panneauBas() {
        vueBas = new VueBas (ctrl);
        return vueBas;
    }

    private Component panneauGauche() {
      vueGauche = new VueGauche(ctrl);
      return vueGauche;
    }
    
    
    /**
     * Crée le panneau du centre 
     */
    private Component panneauCentre() {
        vueCentre = new VueCentre(ctrl,lesSommets,lesArretes);
        return vueCentre;
    }

    /**
     * Permet de passer en mode sommet
     */
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

    /**
     * Permet de passer en mode arrete
     */
    private void modeArrete() {
        Cursor curseur = new Cursor(Cursor.CROSSHAIR_CURSOR);
        this.setCursor(curseur);
    }

    
    /**
     * Permet de passer en mode par défault
     */
    private void modeFleche() {
        Cursor curseur = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(curseur);
    }

    
}
