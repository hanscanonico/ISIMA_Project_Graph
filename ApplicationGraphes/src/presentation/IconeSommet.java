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

    private int origineX;
    private int origineY;
    private Sommet monSommet;
    private double[] pos = new double[2];
    private double[] disp = {0,0};

    public double[] getPos() {
        return pos;
    }

    public Sommet getMonSommet() {
        return monSommet;
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }

    public double[] getDisp() {
        return disp;
    }

    public void setDisp(double[] disp) {
        this.disp = disp;
    }

    public IconeSommet(Sommet monSommet) {
        this.monSommet = monSommet;
    }

    public int getOrigineX() {
        return origineX;
    }

    public int getCentreY() {
        return origineY - 20;
    }

    public int getCentreX() {
        return origineX - 20;
    }

    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    public int getOrigineY() {
        return origineY;
    }

    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.monSommet);
        return hash;
    }
}
