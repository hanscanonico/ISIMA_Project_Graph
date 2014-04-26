package presentation;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import metier.IConstantes;

/**
 *
 * @author Hans
 */
public class Fenetre extends JFrame implements IConstantes {

    /**
     * Constructeur
     *
     */
    public Fenetre() {

        setTitle("Logiciel de graphe");
        setSize(LARGEUR_FENETRE_PRINCIPALE, LONGUEUR_FENETRE_PRINCIPALE);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menuFichier = new JMenu("Fichier");
        JMenu menuAlgo = new JMenu("Algorithme");
        
        menuBar.add(menuFichier);
        menuBar.add(menuAlgo);
        
        JMenuItem menuItemEnr = new JMenuItem("Enregister");
        JMenuItem menuItemOuv = new JMenuItem("Ouvrir");
        JMenuItem menuItemQuit = new JMenuItem("Quitter");
        
        menuFichier.add(menuItemEnr);
        menuFichier.add(menuItemOuv);
        menuFichier.add(menuItemQuit);
        
        getContentPane().add(new VueGraphe());

        this.setVisible(true);

    }
}
