/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.bouton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import presentation.Controleur;
import presentation.IconeSommet;

/**
 *
 * @author Hans
 */
public class BoutonSommet extends JButton {
    
    
    public BoutonSommet(Controleur ctrl, String nom, String actionCommand)
    {
        setName(nom);
        setPreferredSize(new Dimension(50, 50));
        setActionCommand(actionCommand);
        addActionListener(ctrl);
        
    }
    
      /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int t = IconeSommet.taille;
        int pos=(50-t)/2;
        // on active l'antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(199, 245, 254));
        g2.fillOval(pos, pos, IconeSommet.taille, IconeSommet.taille);
        g2.setColor(Color.blue);
        g2.drawOval(pos, pos, IconeSommet.taille, IconeSommet.taille);
        
        
    }
}
