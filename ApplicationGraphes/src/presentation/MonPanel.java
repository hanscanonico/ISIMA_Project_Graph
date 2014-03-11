package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import metier.Graphe;
import metier.Sommet;

public class MonPanel extends JPanel {
    
    private Graphe graphe;


    public MonPanel(Graphe graphe) {
        this.graphe = graphe;
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(Color.red);

        // g.drawOval(50, 50, 50, 50);
        for (Iterator it =  graphe.getLesSommets().iterator(); it.hasNext();) {
            Sommet som =  (Sommet) it.next();
            tracerSommet(g2, som.getMonIcone());
            
        }


    }

    private void tracerSommet(Graphics2D g2,IconeSommet ico) {
        g2.setColor(Color.red);
        g2.drawOval(ico.getOrigineY(), ico.getOrigineX(), 40, 40);
        System.out.println(ico.getOrigineY() +"-"+ ico.getOrigineX());
    }
    
  
}