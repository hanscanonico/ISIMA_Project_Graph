/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import metier.Sommet;

/**
 *
 * @author Amine
 */
public class IconeSommet {

    private int origineX;
    private int origineY;

    public int getOrigineX() {
        return origineX;
    }

    public int getCentreY() {
        return origineY-20;
    }

    public int getCentreX() {
        return origineX-20;
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
}
