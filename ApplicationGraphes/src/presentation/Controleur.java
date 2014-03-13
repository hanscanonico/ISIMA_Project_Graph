/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import coucheApplicative.Modele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import metier.IConstantes;

/**
 *
 * @author Hans
 */
public class Controleur implements ActionListener, IConstantes {

    private Modele mdl;

    public Controleur(Modele mdl) {

        this.mdl = mdl;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String commande = ae.getActionCommand();
        if (commande.equals(MODE_SOMMET)) {
            mdl.modeSommet();
        } else if (commande.equals(MODE_ARRETE)) {
            mdl.modeArrete();
        } else if (commande.equals(MODE_FLECHE)) {
            mdl.modeFleche();
        }
    }
}
