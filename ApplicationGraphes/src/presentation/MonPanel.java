package presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MonPanel extends JPanel{
	public void paintComponent(Graphics g){
            
                g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
                
               // g.drawOval(50, 50, 50, 50);
                this.tracerCercle(g);
                g.setColor(Color.blue);
                g.drawOval(150, 50, 50, 50);
                g.drawLine(100, 75, 150,75);
         
	}
        
        private void tracerCercle(Graphics g){
            g.setColor(Color.red);
            g.drawOval(50, 50, 50, 50);
        }
        
}