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
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Amine
 */
public class IconeSommet extends JComponent {

//  la taille d'un iconeSommet
    /**
     *
     */
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
    private JLabel label;
    private String nom;
    private Color couleur;
//sommet selectionné
    private boolean isSelected;

    /**
     * retourne la taille d'un icone Sommet
     *
     * @return
     */
    public static int getTaille() {
        return taille;
    }

    /**
     * retoure le label
     *
     * @return le label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * setter de label
     *
     * @param label
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * getter de nom
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter de nom
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter du textfield
     *
     * @return
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * getter de pos
     *
     * @return la pos
     */
    public double[] getPos() {
        return pos;
    }

    /**
     * setter de pos
     *
     * @param pos la pos
     */
    public void setPos(double[] pos) {
        this.pos = pos;
    }

    /**
     * Constructeur
     *
     * @param ctrl
     * @param pos
     * @param x
     * @param y
     * @param nom
     */
    public IconeSommet(Controleur ctrl, double[] pos, int x, int y, String nom) {
        setLayout(new BorderLayout());
        setLocation(new Point(x, y));
        setOrigineX(x);
        setOrigineY(y);
        
        this.nom = nom;
        this.addMouseMotionListener(ctrl);
        label = new JLabel(nom, SwingConstants.CENTER);
        label.setVisible(false);
        
        label.setPreferredSize(new Dimension(20, 25));
        
        textField = new JTextField(nom);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setPreferredSize(new Dimension(20, 25));
        add(label, BorderLayout.SOUTH);
        add(textField, BorderLayout.SOUTH);
        
        textField.addActionListener(ctrl);
        textField.addFocusListener(ctrl);
        textField.addKeyListener(ctrl);        
        label.addMouseListener(ctrl);
        
        this.addFocusListener(ctrl);
        this.addMouseListener(ctrl);
        this.addKeyListener(ctrl);
        this.addMouseMotionListener(ctrl);
        couleur = new Color(176, 226, 221);
        setEnabled(true);
        setVisible(true);
    }

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int t = IconeSommet.taille;
        // on active l'antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(couleur);
        g2.fillOval(0, 0, IconeSommet.taille, IconeSommet.taille);
        g2.setColor(Color.darkGray);
        g2.drawOval(0, 0, IconeSommet.taille, IconeSommet.taille);
        
        
    }

    /**
     * getter de OrigineX
     *
     * @return l'origineX
     */
    public int getOrigineX() {
        return origineX;
    }

    /**
     * Donne le centreY
     *
     * @return le CentreY
     */
    public int getCentreY() {
        return origineY + taille / 2;
    }

    /**
     * Donne le centreX
     *
     * @return le centreX
     */
    public int getCentreX() {
        return origineX + taille / 2;
    }

    /**
     * setter de OrigineX
     *
     * @param origineX l'origineX
     */
    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    /**
     * getter de origineY
     *
     * @return l'origineY
     */
    public int getOrigineY() {
        return origineY;
    }

    /**
     * setter de OrigineY
     *
     * @param origineY l'origineY
     */
    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

    /**
     * Compare 2 iconeSommets
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof IconeSommet) {
            IconeSommet ico=(IconeSommet)obj;
            if(ico.isSelected==isSelected)
            {
                if(ico.getLabel().getText().equals(getLabel().getText()))
                {
                    equal=true;
                }
            }
        }
        return equal;
    }

    /**
     * retourne un hashCode
     *
     * @return un hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash;
        return hash;
    }

    /**
     * met à jour le nom du sommet
     *
     * @param nouv le nouveau nom du sommet
     */
    public void updateName(String nouv) {
        this.setNom(nouv);
        textField.setText(nouv);
        label.setText(nouv);
        label.setVisible(true);
        remove(textField);
        repaint();
        add(label, BorderLayout.SOUTH);
        repaint();
        
    }

    /**
     * affiche un textfield
     *
     */
    void modeTextField() {
        
        remove(label);
        repaint();
        add(textField, BorderLayout.SOUTH);
        textField.selectAll();
        textField.requestFocus();
        repaint();
    }

    /**
     *
     */
    public void modeSelection() {
        couleur = Color.BLACK;        
        isSelected = true;
        update(getGraphics());
        revalidate();
        repaint();
    }

    /**
     *
     */
    public void modeNonSelection() {
        isSelected = false;
        couleur = new Color(176, 226, 221);        
        
        update(getGraphics());
        revalidate();
        repaint();
    }
}
