package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MonPanel extends JPanel{
	public void paintComponent(Graphics g){
            
            Graphics2D g2 = (Graphics2D)g;
   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                        
                g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                
               // g.drawOval(50, 50, 50, 50);
                this.tracerCercle(g2);
                g2.setColor(Color.blue);
                g2.drawOval(150, 50, 50, 50);
                g2.drawLine(100, 75, 150,75);
         
	}
        
        private void tracerCercle(Graphics2D g){
            g.setColor(Color.red);
            g.drawOval(50, 50, 50, 50);
        }
        
}