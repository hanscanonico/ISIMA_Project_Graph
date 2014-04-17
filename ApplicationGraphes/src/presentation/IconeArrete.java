/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
 *
 * @author Amine
 */
public class IconeArrete extends JComponent {

//  le premier iconeSommet
    private IconeSommet som1;
//  le deuxième iconeSommet
    private IconeSommet som2;
//  la position
    private double[] pos = new double[2];
//  la disposition
    private double[] disp = new double[2];

    /**
     * Constructeur
     *
     * @param som1 le premier iconeSommet
     * @param som2 le deuxièeme iconeSommet
     */
    public IconeArrete(IconeSommet som1, IconeSommet som2) {
        setLayout(new BorderLayout());
        
        this.som1 = som1;
        this.som2 = som2;
    }

    /**
     * getter de iconeSOmmet1
     *
     * @return l'iconeSommet1
     */
    public IconeSommet getSom1() {
        return som1;
    }

    /**
     *
     * @param som1
     */
    public void setSom1(IconeSommet som1) {
        this.som1 = som1;
    }

    /**
     * getter de iconeSommet2
     *
     * @return l'iconeSommet2
     */
    public IconeSommet getSom2() {
        return som2;
    }

    /**
     * setter de iconeSommet2
     *
     * @param som2 un iconeSommet
     */
    public void setSom2(IconeSommet som2) {
        this.som2 = som2;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setVisible(true);
        setLocation(new Point(10, 10));
         setBounds(0, 0, 500, 500);
        Graphics2D g2 = (Graphics2D) g;
        int x1, x2, y1, y2;
        x1 = som1.getCentreX();
        y1 = som1.getCentreY();
        x2 = som2.getCentreX();
        y2 = som2.getCentreY();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.CYAN);
        g2.draw(new Line2D.Double(x1, y1, x2, y2));
        g.drawLine(x1, y1, x2, y2);

    }
}
