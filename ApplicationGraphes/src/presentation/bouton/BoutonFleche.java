/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.bouton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import presentation.Controleur;

/**
 *
 * @author Amine
 */
public class BoutonFleche extends JButton {

    private Image image;

    public BoutonFleche(Controleur ctrl, String nom, String actionCommand) {
        setName(nom);
        setPreferredSize(new Dimension(50, 50));
        setActionCommand(actionCommand);
        addActionListener(ctrl);
        image = getToolkit().getImage("image/curseur.png");
    }

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(image, 15, 10, getParent());


    }
}
