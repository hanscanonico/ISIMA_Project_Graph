/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private Color couleur;
    /**
     * Constructeur
     *
     * @param som1 le premier iconeSommet
     * @param som2 le deuxièeme iconeSommet
     */
    public IconeArrete(IconeSommet som1, IconeSommet som2,Controleur ctrl) {
        setLayout(new BorderLayout());

        this.som1 = som1;
        this.som2 = som2;
//        this.addFocusListener(ctrl);
//        this.addMouseListener(ctrl); 
//        this.addKeyListener(ctrl);
      
        couleur=Color.GRAY;
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

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {

        //setVisible(true);

        Graphics2D g2 = (Graphics2D) g;
        int x1, x2, y1, y2;
        x1 = som1.getCentreX();
        y1 = som1.getCentreY();
        x2 = som2.getCentreX();
        y2 = som2.getCentreY();
        setBounds(0, 0, getParent().getWidth(), getParent().getHeight());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(couleur);
        g2.drawLine(x1, y1, x2, y2);
    }

    public void modeSelection()
    {
        couleur=Color.BLACK;
        update(getGraphics());
        revalidate();
        repaint();
        
    }
    public void modeNonSelection()
    {
        couleur=Color.GRAY;
        update(getGraphics());
        revalidate();
        repaint();
        
    }
    
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(som1).append(som2);
        return sb.toString();
    }
    
    
}
