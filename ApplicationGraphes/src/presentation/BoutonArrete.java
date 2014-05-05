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
import javax.swing.JButton;

/**
 *
 * @author Hans
 */
public class BoutonArrete extends JButton{
    
    public BoutonArrete(Controleur ctrl, String nom, String actionCommand)
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
      
    //    setBounds(0, 0, getParent().getWidth(), getParent().getHeight());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.drawLine(0,0,40,40);
        
    }
}
