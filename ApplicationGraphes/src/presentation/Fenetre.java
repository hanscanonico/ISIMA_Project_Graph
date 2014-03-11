package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Box.Filler;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import metier.Sommet;

public class Fenetre extends JFrame {

    private metier.Graphe g;
    private ArrayList<IconeArrete> icoArr;
    private ArrayList<IconeSommet> icoSomm;

    public Fenetre(metier.Graphe g) {
        this.g = g;

        this.setTitle("graaaaaaaph");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculPosition();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Fichier");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
        mnNewMenu.add(mntmNewMenuItem);
        JPanel pan = new MonPanel(g);

        pan.setBackground(Color.WHITE);

        this.setContentPane(pan);


        this.setVisible(true);
    }
    int temp;

    private void calculPosition() {
        for (Iterator<Sommet> it = g.getLesSommets().iterator(); it.hasNext();) {
            Sommet som = it.next();
            temp = (int) (Math.random() * (this.getWidth()-100));
            som.getMonIcone().setOrigineX(temp);
            temp = (int) (Math.random() * (this.getHeight()-100));
            som.getMonIcone().setOrigineY(temp);

        }
    }
}
