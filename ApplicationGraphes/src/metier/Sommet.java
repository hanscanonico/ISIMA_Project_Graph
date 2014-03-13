package metier;

import presentation.*;

/**
 *
 * @author Hans
 */
public class Sommet {

    private String nom;
    private int valeur;

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param nom
     * @param val
     */
    public Sommet(String nom, int val) {
        setNom(nom);
        setValeur(val);
       
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
     *
     * @return
     */
    public int getValeur() {
        return valeur;
    }

    /**
     *
     * @param valeur
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
