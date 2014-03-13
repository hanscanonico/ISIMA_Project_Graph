package metier;

import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public class Graphe {

    /**
     * la liste des sommet d'un graphe *
     */
    private ArrayList<Sommet> lesSommets;
    private ArrayList<Arrete> lesArretes;

    /**
     *
     * @param s
     */
    public void ajouterSommet(Sommet s) {
        lesSommets.add(s);
    }

    /**
     *
     * @return
     */
    public ArrayList<Sommet> getLesSommets() {
        return lesSommets;
    }

    /**
     *
     * @return
     */
    public ArrayList<Arrete> getLesArretes() {
        return lesArretes;
    }

    /**
     *
     * @param sommets
     */
    public void ajouterSommets(ArrayList<Sommet> sommets) {
        lesSommets.addAll(sommets);
    }

    /**
     *
     * @param s
     */
    public void supprimerSommet(Sommet s) {
        lesSommets.remove(s);
    }

    /**
     *
     * @param a
     */
    public void ajouterArrete(Arrete a) {
        lesArretes.add(a);
    }

    /**
     *
     * @param arretes
     */
    public void ajouterArretes(ArrayList<Arrete> arretes) {
        lesArretes.addAll(arretes);
    }

    /**
     *
     * @param a
     */
    public void supprimerArrete(Arrete a) {
        lesArretes.remove(a);

    }

    /**
     *
     */
    public Graphe() {
        lesSommets = new ArrayList<Sommet>();
        lesArretes = new ArrayList<Arrete>();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Arrete a : lesArretes) {
            sb.append(a).append("\n");
        }
        return sb.toString();
    }
}
