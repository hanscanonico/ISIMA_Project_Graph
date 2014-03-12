package presentation;

import java.awt.Color;
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
import metier.Sommet;

public class Fenetre extends JFrame {

    private metier.Graphe g;
    private Set icoArr = new HashSet();
    private Set icoSomm = new HashSet();
    private Map<Sommet,IconeSommet> icoSom = new HashMap<>();

    public Fenetre(metier.Graphe g) {
        this.g = g;
        generationDesIcones();
        calculPosition();
        calculPosition2();
        for (Iterator it = icoSomm.iterator(); it.hasNext();) {
            IconeSommet object = (IconeSommet) it.next();
            System.out.println(object.getDisp()[0]);
        }

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
        JPanel pan = new MonPanel(g, icoArr, icoSomm);

        pan.setBackground(Color.WHITE);

        this.setContentPane(pan);


        this.setVisible(true);

    }

    private void calculPosition() {
        int temp;
        for (Iterator<IconeSommet> it = icoSomm.iterator(); it.hasNext();) {
            IconeSommet som = it.next();
            temp = (int) (Math.random() * (this.getWidth() - 100));
            som.getPos()[0] = temp;
            temp = (int) (Math.random() * (this.getHeight() - 100));
            som.getPos()[1] = temp;

        }

    }

    private void generationDesIcones() {
        Arrete arr;
        Sommet som;
        IconeArrete newIcoArr;
        IconeSommet newIcosom1;
        IconeSommet newIcosom2;

        for (Iterator<Sommet> it = g.getLesSommets().iterator(); it.hasNext();) {
            som = it.next();
            newIcosom1 = new IconeSommet(som);
            this.icoSomm.add(newIcosom1);
            this.icoSom.put(som, newIcosom1);
        }
        for (Iterator<Arrete> it = g.getLesArretes().iterator(); it.hasNext();) {
            arr = it.next();
            newIcosom1 = icoSom.get(arr.getSommet1());
            newIcosom2 =  icoSom.get((arr.getSommet2()));

            newIcoArr = new IconeArrete(newIcosom1, newIcosom2);
            this.icoArr.add(newIcoArr);
        }


    }

    private void calculPosition2() {
        double area = getWidth() * getHeight();
        double k = Math.sqrt(area / icoSomm.size());
        double[] delta = new double[2];
        double[] temp = new double[2];

        for (Iterator<IconeSommet> it = icoSomm.iterator(); it.hasNext();) {
            IconeSommet v = it.next();
            for (Iterator<IconeSommet> it2 = icoSomm.iterator(); it2.hasNext();) {
                IconeSommet u = it2.next();
                if (v != u) {
                    delta[0] = v.getPos()[0] - u.getPos()[0];
                    delta[1] = v.getPos()[1] - u.getPos()[1];
                }
            }

        }
    }

    private double fonctionA(double z, double k) {
        double temp;
        temp = z * z / k;
        return temp;

    }

    private double fonctionR(double z, double k) {
        double temp;
        temp = k * k / z;

        return temp;

    }
}
