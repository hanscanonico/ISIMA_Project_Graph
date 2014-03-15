/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.Objects;
import metier.Sommet;

/**
 *
 * @author Amine
 */
public class IconeSommet {

//  la taille d'un iconeSommet
    public static int taille = 20;
//  l'origineX d'un iconeSommet
    private int origineX;
//  l'origineY d'un iconeSommet
    private int origineY;

//  la pos
    private double[] pos = new double[2];
//  la disp
    private double[] disp = {0, 0};

    /**
     * getter de pos
     * @return la pos
     */
    public double[] getPos() {
        return pos;
    }

  
    /**
     * setter de pos
     * @param pos la pos
     */
    public void setPos(double[] pos) {
        this.pos = pos;
    }

    /**
     * getter de disp
     * @return la disp
     */
    public double[] getDisp() {
        return disp;
    }

    /**
     * setter de disp
     * @param disp la disp
     */
    public void setDisp(double[] disp) {
        this.disp = disp;
    }

    /**
     * Constructeur
     * @param monSommet le sommet
     */
    public IconeSommet() {
    }

    /**
     * getter de OrigineX
     * @return l'origineX
     */
    public int getOrigineX() {
        return origineX;
    }

    /**
     * Donne le centreY
     * @return le CentreY
     */
    public int getCentreY() {
        return origineY + taille / 2;
    }

    /**
     * Donne le centreX
     * @return le centreX
     */
    public int getCentreX() {
        return origineX + taille / 2;
    }

    /**
     * setter de OrigineX
     * @param origineX l'origineX
     */
    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    /**
     * getter de origineY
     * @return l'origineY
     */
    public int getOrigineY() {
        return origineY;
    }

    /**
     * setter de OrigineY
     * @param origineY l'origineY
     */
    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

    /**
     * Compare 2 iconeSommets
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        boolean equal=true;
        if (obj == null) {
            equal=false;
        }
        if (obj == this) {
            equal=true;
        }
        if (!(obj instanceof IconeSommet)) {
            equal=false;
        }
        return equal;
    }

    /**
     * retourne un hashCode
     * @return un hashCode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash;
        return hash;
    }
}
