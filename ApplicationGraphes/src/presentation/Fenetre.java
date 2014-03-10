package presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Box.Filler;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Fenetre extends JFrame {

	public Fenetre() {
		this.setTitle("graaaaaaaph");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    JMenu mnNewMenu = new JMenu("Fichier");
	    menuBar.add(mnNewMenu);
	    
	    JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
	    mnNewMenu.add(mntmNewMenuItem);
	    JPanel pan = new MonPanel();
	    
	    pan.setForeground(Color.BLACK);
	    
	    pan.setBackground(Color.WHITE);        
	    this.setContentPane(pan);


		this.setVisible(true);
	}
}