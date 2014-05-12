package metier;

import java.util.ArrayList;
import presentation.*;

/**
 *
 * @author Hans
 */
public class Arrete {

//  le premier sommet de l'arrête  
    private Sommet sommet1;
//  le deuxieme sommet de l'arrête
    private Sommet sommet2;
    private int poid;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getPoid() {
        return poid;
    }

    public final void setPoid(int poid) {
        if (poid < 0) {
            throw new IllegalArgumentException();
        } else {
            this.poid = poid;
        }
    }

    /**
     * getter de sommet1
     *
     * @return le sommet1
     */
    public Sommet getSommet1() {
        return sommet1;
    }

    /**
     * setter de sommet1
     *
     * @param sommet1 un sommet
     */
    public final void setSommet1(Sommet sommet1) {
        this.sommet1 = sommet1;
    }

    /**
     * getter de sommet2
     *
     * @return le sommet2
     */
    public Sommet getSommet2() {
        return sommet2;
    }

    /**
     * setter de sommet2
     *
     * @param sommet2 un sommet
     */
    public final void setSommet2(Sommet sommet2) {
        this.sommet2 = sommet2;
    }

    /**
     * Constructeur
     *
     * @param sommet1 le sommet1
     * @param sommet2 le sommet2
     */
    public Arrete(Sommet sommet1, Sommet sommet2) {
        setSommet1(sommet1);
        setSommet2(sommet2);
    }

    /**
     * Constructeur
     *
     * @param sommet1 le sommet1
     * @param sommet2 le sommet2
     */
    public Arrete(Sommet sommet1, Sommet sommet2, int poid) {
        this(sommet1, sommet2);
        setPoid(poid);
    }

    public boolean containsSommet(Sommet s) {
        return sommet1.equals(s) || sommet2.equals(s);
    }

    /**
     * toString de arrête
     *
     * @return la description du sommet
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("arrete ");
        sb.append(sommet1);
        sb.append(sommet2);
        return sb.toString();
    }
}
