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

    /**
     *
     */
    public static int taille = 20;
    private int origineX;
    private int origineY;
    private Sommet monSommet;
    private double[] pos = new double[2];
    private double[] disp = {0, 0};

    /**
     *
     * @return
     */
    public double[] getPos() {
        return pos;
    }

    /**
     *
     * @return
     */
    public Sommet getMonSommet() {
        return monSommet;
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

    /**
     *
     * @param monSommet
     */
    public IconeSommet(Sommet monSommet) {
        this.monSommet = monSommet;
    }

    /**
     *
     * @return
     */
    public int getOrigineX() {
        return origineX;
    }

    /**
     *
     * @return
     */
    public int getCentreY() {
        return origineY + taille / 2;
    }

    /**
     *
     * @return
     */
    public int getCentreX() {
        return origineX + taille / 2;
    }

    /**
     *
     * @param origineX
     */
    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    /**
     *
     * @return
     */
    public int getOrigineY() {
        return origineY;
    }

    /**
     *
     * @param origineY
     */
    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IconeSommet)) {
            return false;
        }
        IconeSommet aux = (IconeSommet) obj;
        return this.monSommet == aux.monSommet;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.monSommet);
        return hash;
    }
}
