/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import metier.Arrete;
import metier.Sommet;

/**
 *
 * @author Amine
 */
public class IconeArrete {

//  le premier iconeSommet
    private IconeSommet som1;
//  le deuxième iconeSommet
    private IconeSommet som2;
//  la position
    private double[] pos = new double[2];
//  la disposition
    private double[] disp = new double[2];

    /**
     * Constructeur
     *
     * @param som1 le premier iconeSommet
     * @param som2 le deuxièeme iconeSommet
     */
    public IconeArrete(IconeSommet som1, IconeSommet som2) {
        this.som1 = som1;
        this.som2 = som2;
    }

    /**
     * getter de iconeSOmmet1
     *
     * @return l'iconeSommet1
     */
    public IconeSommet getSom1() {
        return som1;
    }

    /**
     *
     * @param som1
     */
    public void setSom1(IconeSommet som1) {
        this.som1 = som1;
    }

    /**
     * getter de iconeSommet2
     *
     * @return l'iconeSommet2
     */
    public IconeSommet getSom2() {
        return som2;
    }

    /**
     * setter de iconeSommet2
     *
     * @param som2 un iconeSommet
     */
    public void setSom2(IconeSommet som2) {
        this.som2 = som2;
    }

    /**
     * getter de pos
     *
     * @return la pos
     */
    public double[] getPos() {
        return pos;
    }

    /**
     * setter de pos
     *
     * @param pos une pos
     */
    public void setPos(double[] pos) {
        this.pos = pos;
    }

    /**
     * getter de disp
     *
     * @return la disp
     */
    public double[] getDisp() {
        return disp;
    }

    /**
     * setter de disp
     *
     * @param disp une disp
     */
    public void setDisp(double[] disp) {
        this.disp = disp;
    }
}
