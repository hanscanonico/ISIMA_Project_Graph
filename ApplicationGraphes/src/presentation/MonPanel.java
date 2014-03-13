package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JPanel;
import metier.Graphe;
import metier.Sommet;

/**
 *
 * @author Hans
 */
public class MonPanel extends JPanel {

    private Graphe graphe;
    private Set<IconeArrete> icoArr;
    private Set<IconeSommet> icoSomm;

    /**
     *
     * @param graphe
     * @param icoArr
     * @param icoSomm
     */
    public MonPanel(Graphe graphe, Set icoArr, Set icoSomm) {
        super();
        this.graphe = graphe;
        this.icoArr = icoArr;
        this.icoSomm = icoSomm;
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
            g2.drawChars(som.getMonSommet().getNom().toCharArray(), 0, 1, (int) som.getPos()[1], (int)som.getPos()[0]);
            
        }

    }

    private void tracerArretes(Graphics2D g2) {

        for (IconeArrete icoA : icoArr) {
            IconeArrete arr = icoA;
            g2.setColor(Color.red);
            g2.drawLine((int) arr.getSom1().getPos()[1] + 20, (int) arr.getSom1().getPos()[0] + 20, (int) arr.getSom2().getPos()[1] + 20, (int) arr.getSom2().getPos()[0] + 20);
            System.out.println(arr.getSom1().getPos()[1] + "-" + arr.getSom1().getPos()[0]);
            System.out.println(arr.getSom2().getPos()[1] + "-" + arr.getSom2().getPos()[0]);
            System.out.println();
        }

    }
}