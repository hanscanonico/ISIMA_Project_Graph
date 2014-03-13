package metier;

import javax.swing.UIManager;
import presentation.Fenetre;

/**
 *
 * @author Hans
 */
public class Test {

    /**
     *
     * @param arg
     */
    public static void main(String[] arg) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Graphe g = new Graphe();
        Sommet a = new Sommet("A", 1);
        Sommet b = new Sommet("B", 2);
        Sommet c = new Sommet("C", 3);
        Sommet d = new Sommet("D", 3);
        Arrete ab = new Arrete(a, b);
        Arrete ac = new Arrete(a, c);
        Arrete bc = new Arrete(b, c);
        g.ajouterSommet(a);
        g.ajouterSommet(b);
        g.ajouterSommet(c);
        g.ajouterSommet(d);
        g.ajouterArrete(ab);
        g.ajouterArrete(ac);
        g.ajouterArrete(bc);
        Fenetre fen = new Fenetre(g);



    }
}
