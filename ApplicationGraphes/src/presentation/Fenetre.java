package presentation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import metier.Arrete;
import metier.Graphe;
import metier.IConstantes;
import metier.Sommet;

/**
 *
 * @author Hans
 */
public class Fenetre extends JFrame implements IConstantes {

    /**
     *
     * @param g
     */
    public Fenetre(Graphe g) {

        setTitle("Logiciel de graphe");
        setSize(LARGEUR_FENETRE_PRINCIPALE, LONGUEUR_FENETRE_PRINCIPALE);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu mnNewMenu = new JMenu("Fichier");
        menuBar.add(mnNewMenu);
        JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
        mnNewMenu.add(mntmNewMenuItem);
        getContentPane().add(new VueGraphe(g));

        this.setVisible(true);

    }
}
