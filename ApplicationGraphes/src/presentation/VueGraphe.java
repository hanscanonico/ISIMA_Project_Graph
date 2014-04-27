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
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import metier.IConstantes;
import static metier.IConstantes.ARRETE_TEMP;
import static metier.IConstantes.CHANGER_NOM;
import static metier.IConstantes.TOUT_SUPPRIMER;
import static metier.IConstantes.MODE_NON_SELECTION_SOMMET;

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
    private Map<String, IconeSommet> lesIconesSommets;
// Map de iconeArrete avec pour clé la concatéantion du nom des 2 sommets de chaque extrémité
    private Map<String, IconeArrete> lesIconesArretes;

    /**
     * Constructeur
     */
    public VueGraphe() {
        lesIconesSommets = new HashMap();
        lesIconesArretes = new HashMap();
        setLayout(new BorderLayout());
        mdl = new Modele();
        mdl.addObserver(this);
        ctrl = new Controleur(mdl);
        add(panneauCentre(), BorderLayout.CENTER);
        add(panneauGauche(), BorderLayout.WEST);
        add(panneauBas(), BorderLayout.SOUTH);
        this.setVisible(true);
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
     *
     * @param objetObserve l'objet observé
     * @param uneInformation l'information
     */
    public void update(Observable objetObserve, Object uneInformation) {
        if (objetObserve instanceof Modele) {
            String tabInfos[] = uneInformation.toString().split(SEPARATEUR);
            switch (tabInfos[0]) {
                case MODE_SOMMET:
                    modeSommet();
                    break;
                case MODE_ARRETE:
                    modeArrete();
                    break;
                case MODE_FLECHE:
                    modeFleche();
                    break;
                case AJOUTER_SOMMET:
                    double x = Double.parseDouble(tabInfos[1]);
                    double y = Double.parseDouble(tabInfos[2]);
                    String nomSommet = tabInfos[3];
                    vueCentre.ajouterSommet(nomSommet, x, y, ctrl);
                    break;
                case TOUT_SUPPRIMER:
                    viderGraphe();
                    break;
                case CHANGER_NOM: {
                    IconeSommet aux = lesIconesSommets.get(tabInfos[1]);
                    aux.updateName(tabInfos[2]);
                    lesIconesSommets.remove(tabInfos[1]);
                    lesIconesSommets.put(tabInfos[2], aux);
                    break;
                }
                case AFFICHE_TEXTF: {
                    IconeSommet aux = lesIconesSommets.get(tabInfos[1]);
                    aux.modeTextField();
                    aux.validate();
                    break;
                }
                case MODE_SELECTION_SOMMET: {
                    IconeSommet aux = lesIconesSommets.get(tabInfos[1]);
                    aux.modeSelection();
                    break;
                }
                case MODE_NON_SELECTION_SOMMET: {
                    IconeSommet aux = lesIconesSommets.get(tabInfos[1]);
                    if (aux != null) {
                        aux.modeNonSelection();
                    }
                    break;
                }
                case AJOUTER_ARRETE: {
                    IconeSommet i1, i2;
                    i1 = lesIconesSommets.get(tabInfos[1]);
                    i2 = lesIconesSommets.get(tabInfos[2]);
                    IconeArrete nouv = new IconeArrete(i1, i2);
                    lesIconesArretes.put(i1.getNom() + i2.getNom(), nouv);
                    vueCentre.ajouterArrete(nouv);
                    break;
                }
                case SUPPRIMER_SOMMET: {
                    IconeSommet icoSommet = lesIconesSommets.remove(tabInfos[1]);
                 
                    vueCentre.remove(icoSommet);


                    vueCentre.repaint();
                    vueCentre.validate();

                    break;

                }
                case SUPPRIMER_ARRETE: {
                    IconeArrete icoArrete = lesIconesArretes.remove(tabInfos[1]+tabInfos[2]);
                    if(icoArrete==null)
                    {
                        icoArrete= lesIconesArretes.remove(tabInfos[2]+tabInfos[1]);
                    }
                    vueCentre.remove(icoArrete);
                    vueCentre.repaint();
                    vueCentre.validate();
                    break;
                }
                case ARRETE_TEMP: {
                    int x1 = Integer.parseInt(tabInfos[1]);
                    int x2 = Integer.parseInt(tabInfos[2]);
                    int y1 = Integer.parseInt(tabInfos[3]);
                    int y2 = Integer.parseInt(tabInfos[4]);


                    vueCentre.afficherArreteTemp(x1, x2, y1, y2);
                    break;
                }
                case MASQUER_TEMP: {
                    vueCentre.masquerArreteTemp();
                    break;
                }
            }
        }
    }

    /**
     * génère un graphe
     */
    public void viderGraphe() {
        //generationDesIcones();
        lesIconesArretes.clear();
        lesIconesSommets.clear();
        vueCentre.removeAll();
        vueCentre.repaint();
        // vueCentre.repaint();
    }

    /**
     * Crée le panneau du bas
     */
    private Component panneauBas() {
        vueBas = new VueBas(ctrl);
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
        vueCentre = new VueCentre(ctrl, lesIconesSommets, lesIconesArretes);
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
