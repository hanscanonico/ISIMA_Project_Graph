package presentation;

import javax.swing.UIManager;
import javax.swing.UIManager.*;
import metier.Arrete;
import metier.Graphe;
import metier.Sommet;

public class Affichage {

    public static void main(String[] args) {

        Graphe g = new Graphe();
        Sommet a = new Sommet("A", 1);
        Sommet b = new Sommet("B", 2);
        Sommet c = new Sommet("C", 3);
        Arrete ab = new Arrete(a, b);
        Arrete ac = new Arrete(a, c);
        Arrete bc = new Arrete(b, c);
        g.ajouterSommet(a);
        g.ajouterSommet(b);
        g.ajouterSommet(c);
        g.ajouterArrete(ab);
        g.ajouterArrete(ac);
        g.ajouterArrete(bc);
        
        Fenetre fen = new Fenetre(g);
        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }
}
