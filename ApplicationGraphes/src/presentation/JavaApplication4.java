package javaapplication4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import presentation.IconeArrete;
import presentation.IconeSommet;

/**
 *
 * @author Amine
 */
public class JavaApplication4 extends JComponent{
    private static double[] pos;

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame j = new JFrame();
        JPanel pan = new JPanel();
        j.setVisible(true);
        j.setSize(new Dimension(600, 600));
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setContentPane(pan);
        pan.setBackground(Color.white);
        IconeSommet i1,i2;
        i1 = new IconeSommet(null, pos, 20, 30, "a");
        i2 = new IconeSommet(null, pos, 20, 60, "a");
        IconeArrete a = new IconeArrete(i1, i2);
        a.setBounds(new Rectangle((int) 0, (int) 0, 20, 45));
        a.validate();
        pan.add(a);
        pan.repaint();
          
        
    }
}
