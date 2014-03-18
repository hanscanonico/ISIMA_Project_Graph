/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Amine
 */
public class IconeSommet extends javax.swing.JPanel{

//  la taille d'un iconeSommet
    public static int taille = 20;
//  l'origineX d'un iconeSommet
    private int origineX;
//  l'origineY d'un iconeSommet
    private int origineY;

//  la pos
    private double[] pos = new double[2];
//  la disp
    private double[] disp = {0, 0};

    private JTextField textField;
    
    
    /**
     * getter de pos
     * @return la pos
     */
    public double[] getPos() {
        return pos;
    }

  
    /**
     * setter de pos
     * @param pos la pos
     */
    public void setPos(double[] pos) {
        this.pos = pos;
    }

    /**
     * getter de disp
     * @return la disp
     */
    public double[] getDisp() {
        return disp;
    }

    /**
     * setter de disp
     * @param disp la disp
     */
    public void setDisp(double[] disp) {
        this.disp = disp;
    }

    /**
     * Constructeur
     * @param monSommet le sommet
     */
    public IconeSommet(Controleur ctrl,double[] pos) {
        setLayout(new BorderLayout());
        setPos(pos);
        System.out.println("iconeSommet constructeur");
        setBackground(Color.yellow);
        setMinimumSize(new Dimension(50, 50));
        setPreferredSize(new Dimension(50, 50));
        JPanel conteneurTextFiel=new JPanel();
        conteneurTextFiel.setPreferredSize(new Dimension(10, 10));
        
        textField=new JTextField("");
        textField.setSize(new Dimension(1,1));
        textField.setPreferredSize(new Dimension(1,1));
        textField.setBackground(Color.ORANGE);
        conteneurTextFiel.add(textField);
        add(conteneurTextFiel);
        textField.addActionListener(ctrl);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("testPaint");
        Graphics2D g2 = (Graphics2D) g;
        int t = IconeSommet.taille;
        // on active l'antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.ORANGE);
        g2.fillOval(origineX, origineY, IconeSommet.taille, IconeSommet.taille);

    }

    
    
    /**
     * getter de OrigineX
     * @return l'origineX
     */
    public int getOrigineX() {
        return origineX;
    }

    /**
     * Donne le centreY
     * @return le CentreY
     */
    public int getCentreY() {
        return origineY + taille / 2;
    }

    /**
     * Donne le centreX
     * @return le centreX
     */
    public int getCentreX() {
        return origineX + taille / 2;
    }

    /**
     * setter de OrigineX
     * @param origineX l'origineX
     */
    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    /**
     * getter de origineY
     * @return l'origineY
     */
    public int getOrigineY() {
        return origineY;
    }

    /**
     * setter de OrigineY
     * @param origineY l'origineY
     */
    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

    /**
     * Compare 2 iconeSommets
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean equal=true;
        if (obj == null) {
            equal=false;
        }
        if (obj == this) {
            equal=true;
        }
        if (!(obj instanceof IconeSommet)) {
            equal=false;
        }
        return equal;
    }

    /**
     * retourne un hashCode
     * @return un hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash;
        return hash;
    }
}
