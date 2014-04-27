package metier;

import presentation.*;

/**
 *
 * @author Hans
 */
public class Sommet {
// le nom du sommet

    private String nom;
// la valeur du sommet
    private int valeur;

    /**
     * Constructeur
     */
    public Sommet() {
        this("Z", 0);
    }

    /**
     * getter de nom
     *
     * @return le nom du sommet
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter de nom
     *
     * @param nom le nom du sommet
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param nom le nom du sommet
     * @param val la valeur du sommet
     */
    public Sommet(String nom, int val) {
        setNom(nom);
        setValeur(val);

    }

    /**
     *
     * @param nom le nom du sommet
     */
    public Sommet(String nom) {
        this(nom, 0);

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNom()).append("(");
        sb.append(getValeur()).append(")");
        return sb.toString();
    }

    /**
     * getter de valeur
     *
     * @return
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * setter de valeur
     *
     * @param valeur
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
