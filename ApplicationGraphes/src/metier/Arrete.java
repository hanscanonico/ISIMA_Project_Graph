package metier;

import presentation.*;

public class Arrete {

    private Sommet sommet1;
    private Sommet sommet2;

    public Sommet getSommet1() {
        return sommet1;
    }

    public void setSommet1(Sommet sommet1) {
        this.sommet1 = sommet1;
    }

    public Sommet getSommet2() {
        return sommet2;
    }

    public void setSommet2(Sommet sommet2) {
        this.sommet2 = sommet2;
    }

    public Arrete(Sommet sommet1, Sommet sommet2) {
        setSommet1(sommet1);
        setSommet2(sommet2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("arrete ");
        sb.append(sommet1);
        sb.append(sommet2);
        return sb.toString();
    }
}
