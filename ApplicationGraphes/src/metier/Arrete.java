package metier;

import presentation.*;

/**
 *
 * @author Hans
 */
public class Arrete {

    
    private Sommet sommet1;
    private Sommet sommet2;

    /**
     *
     * @return
     */
    public Sommet getSommet1() {
        return sommet1;
    }

    /**
     *
     * @param sommet1
     */
    public void setSommet1(Sommet sommet1) {
        this.sommet1 = sommet1;
    }

    /**
     *
     * @return
     */
    public Sommet getSommet2() {
        return sommet2;
    }

    /**
     *
     * @param sommet2
     */
    public void setSommet2(Sommet sommet2) {
        this.sommet2 = sommet2;
    }

    /**
     *
     * @param sommet1
     * @param sommet2
     */
    public Arrete(Sommet sommet1, Sommet sommet2) {
        setSommet1(sommet1);
        setSommet2(sommet2);
    }

    /**
     *
     * @return
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
