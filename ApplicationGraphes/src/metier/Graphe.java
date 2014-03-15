package metier;

import java.util.ArrayList;

/**
 *
 * @author Hans
 */
public class Graphe {

    
//    la liste des sommet d'un graphe
    private ArrayList<Sommet> lesSommets;
//    la liste des arrêtes d'un graphe
    private ArrayList<Arrete> lesArretes;

    /**
     * permet d'ajouter un sommet
     * @param s le sommet à ajouter
     */
    public void ajouterSommet(Sommet s) {
        lesSommets.add(s);
    }

    /**
     * getter de lesSommets
     * @return la liste des sommets
     */
    public ArrayList<Sommet> getLesSommets() {
        return lesSommets;
    }

    /**
     * getter de lesArretes
     * @return la liste des arrêtes
     */
    public ArrayList<Arrete> getLesArretes() {
        return lesArretes;
    }

    /**
     * permet d'ajouter des sommets
     * @param sommets la liste des sommets
     */
    public void ajouterSommets(ArrayList<Sommet> sommets) {
        lesSommets.addAll(sommets);
    }

    /**
     * permet de suppriemr un sommet
     * @param s le sommet à supprimer
     */
    public void supprimerSommet(Sommet s) {
        lesSommets.remove(s);
    }

    /**
     * permet d'ajouter une arrête
     * @param a l'arrête à ajouter
     */
    public void ajouterArrete(Arrete a) {
        lesArretes.add(a);
    }

    /**
     * permet d'ajouter des arrêtes
     * @param arretes les arrêtes à ajouter
     */
    public void ajouterArretes(ArrayList<Arrete> arretes) {
        lesArretes.addAll(arretes);
    }

    /**
     * permet de supprimer une arrête
     * @param a l'arrête à supprimer
     */
    public void supprimerArrete(Arrete a) {
        lesArretes.remove(a);

    }

    /**
     * Constructeur par défault
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
