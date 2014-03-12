package metier;

import java.util.ArrayList;

public class Graphe {

    /**
     * la liste des sommet d'un graphe *
     */
    private ArrayList<Sommet> lesSommets;
    private ArrayList<Arrete> lesArretes;

    public void ajouterSommet(Sommet s) {
        lesSommets.add(s);
    }

    public ArrayList<Sommet> getLesSommets() {
        return lesSommets;
    }

    public ArrayList<Arrete> getLesArretes() {
        return lesArretes;
    }

    public void ajouterSommets(ArrayList<Sommet> sommets) {
        lesSommets.addAll(sommets);
    }

    public void supprimerSommet(Sommet s) {
        lesSommets.remove(s);
    }

    public void ajouterArrete(Arrete a) {
        lesArretes.add(a);
    }

    public void ajouterArretes(ArrayList<Arrete> arretes) {
        lesArretes.addAll(arretes);
    }

    public void supprimerArrete(Arrete a) {
        lesArretes.remove(a);

    }

    public Graphe() {
        lesSommets = new ArrayList<Sommet>();
        lesArretes = new ArrayList<Arrete>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Arrete a : lesArretes) {
            sb.append(a).append("\n");
        }
        return sb.toString();
    }
}
