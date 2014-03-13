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
        Sommet e = new Sommet("E", 3);
        Arrete ab = new Arrete(a, b);
        Arrete ac = new Arrete(a, c);
        Arrete bc = new Arrete(b, c);
        Arrete ad = new Arrete(a, d);
        Arrete bd = new Arrete(b, d);
        Arrete cd = new Arrete(c, d);
        Arrete ae = new Arrete(a, e);
        Arrete be = new Arrete(b, e);
        Arrete ce = new Arrete(c, e);
        Arrete de = new Arrete(d, e);

        g.ajouterSommet(a);
        g.ajouterSommet(b);
        g.ajouterSommet(c);
        g.ajouterSommet(d);
        g.ajouterSommet(e);
        g.ajouterArrete(ab);
        g.ajouterArrete(ac);
        g.ajouterArrete(bc);
        g.ajouterArrete(ad);
        g.ajouterArrete(bd);
        g.ajouterArrete(cd);
        g.ajouterArrete(ae);
        g.ajouterArrete(be);
        g.ajouterArrete(ce);
        g.ajouterArrete(de);
        Fenetre fen = new Fenetre(g);



    }
}
