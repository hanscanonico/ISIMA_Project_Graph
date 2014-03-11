package metier;

import presentation.*;

public class Sommet {

    private String nom;
    private int valeur;
    private IconeSommet monIcone;

    public String getNom() {
        return nom;
    }

    public IconeSommet getMonIcone() {
        return monIcone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Sommet(String nom, int val) {
        setNom(nom);
        setValeur(val);
        this.monIcone=new IconeSommet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNom()).append("(");
        sb.append(getValeur()).append(")");
        return sb.toString();
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
