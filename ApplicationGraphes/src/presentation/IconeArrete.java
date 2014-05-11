/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
// couleu de l'arrete
    private Color couleur;
    private int poid = 0;
// position du label
    private int labX;
// position du label
    private int labY;
// label du poid
    private JLabel label;
    private final JTextField txtfield;

    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        String tmp=Integer.toString(poid);
        label.setText(tmp);
        txtfield.setText(tmp);
        this.poid = poid;
    }

    /**
     * Constructeur
     *
     * @param som1 le premier iconeSommet
     * @param som2 le deuxièeme iconeSommet
     */
    public IconeArrete(IconeSommet som1, IconeSommet som2, Controleur ctrl) {
        setLayout(null);

        this.som1 = som1;
        this.som2 = som2;
        /*   this.addFocusListener(ctrl);
         this.addMouseListener(ctrl); 
         this.addKeyListener(ctrl);*/

        couleur = Color.GRAY;
        label = new JLabel(Integer.toString(poid));
        label.setPreferredSize(new Dimension(30, 25));
        label.setBounds(0, 0, 30, 25);
        label.addMouseListener(ctrl);

        add(label);

        txtfield = new JTextField(Integer.toString(poid));
        txtfield.setPreferredSize(new Dimension(30, 25));
        txtfield.setBounds(0, 0, 30, 25);
        txtfield.setVisible(false);
        txtfield.addActionListener(ctrl);
        txtfield.addFocusListener(ctrl);
        txtfield.addKeyListener(ctrl);

        add(txtfield);
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
        label.setLocation((x1 + x2) / 2, (y1 + y2) / 2);
        txtfield.setLocation((x1 + x2) / 2, (y1 + y2) / 2);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(couleur);
        g2.drawLine(x1, y1, x2, y2);



    }

    public void modeSelection() {
        couleur = Color.BLACK;
        update(getGraphics());
        revalidate();
        repaint();

    }

    public void modeNonSelection() {
        couleur = Color.GRAY;
        update(getGraphics());
        revalidate();
        repaint();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(som1).append(som2);
        return sb.toString();
    }

    void modeTextField() {
        label.setVisible(false);
        txtfield.setVisible(true);
        txtfield.requestFocus();
    }

    void updatePoid(String pod) {
        setPoid(Integer.parseInt(pod));
        txtfield.setVisible(false);
        label.setVisible(true);

    }
}
