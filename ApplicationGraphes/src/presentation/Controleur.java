/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import coucheApplicative.Modele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import metier.IConstantes;

/**
 *
 * @author Hans
 */
public class Controleur implements MouseListener, ActionListener, IConstantes {

    private Modele mdl;
    private String mode=MODE_FLECHE;

    /**
     *
     * @param mdl
     */
    public Controleur(Modele mdl) {

        this.mdl = mdl;
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String commande = ae.getActionCommand();
        if (commande.equals(MODE_SOMMET)) {
            mdl.modeSommet();
            this.mode=MODE_SOMMET;
        } else if (commande.equals(MODE_ARRETE)) {
            mdl.modeArrete();
            this.mode=MODE_ARRETE;
        } else if (commande.equals(MODE_FLECHE)) {
            mdl.modeFleche();
            this.mode=MODE_FLECHE;
        }
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if(mode.equals(MODE_SOMMET))
        {
            mdl.addSommet(me.getX(),me.getY());
        }
    }

    /**
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
     
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {
    
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {
   
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {
   
    }
}
