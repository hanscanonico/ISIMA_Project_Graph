/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;

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
        Graphics2D g2 = (Graphics2D) g;
        int t = IconeSommet.taille;
        // on active l'antialiasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(176, 226, 221));
        g2.fillOval(20, 10, IconeSommet.taille, IconeSommet.taille);
        g2.setColor(Color.darkGray);
        g2.drawOval(20, 10, IconeSommet.taille, IconeSommet.taille);
        
        
    }
}