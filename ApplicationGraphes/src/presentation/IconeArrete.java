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

 private IconeSommet som1;
 private IconeSommet som2;
 private double[] pos = new double[2];
 private double[] disp = new double[2];

    /**
     *
     * @param som1
     * @param som2
     */
    public IconeArrete(IconeSommet som1, IconeSommet som2) {
        this.som1 = som1;
        this.som2 = som2;
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public IconeSommet getSom2() {
        return som2;
    }

    /**
     *
     * @param som2
     */
    public void setSom2(IconeSommet som2) {
        this.som2 = som2;
    }

    /**
     *
     * @return
     */
    public double[] getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(double[] pos) {
        this.pos = pos;
    }

    /**
     *
     * @return
     */
    public double[] getDisp() {
        return disp;
    }

    /**
     *
     * @param disp
     */
    public void setDisp(double[] disp) {
        this.disp = disp;
    }


    
    
}
