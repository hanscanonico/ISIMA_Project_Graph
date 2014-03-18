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
//  le modele
    private Modele mdl;
//  le mode
    private String mode=MODE_FLECHE;

    /**
     * Constructeur
     * @param mdl le modele
     */
    public Controleur(Modele mdl){

        this.mdl = mdl;
    }

    /**
     * evenements boutons
     * @param ae l'évènement
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
        }else if (commande.equals(GENERER)) {
            mdl.generer();
        }
    }

    /**
     * evenement clique de souris
     * @param me l'évènement
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    /**
     * évènement appui sur la souri 
     * @param me l'évènement
     */
    @Override
    public void mousePressed(MouseEvent me) {
     if(mode.equals(MODE_SOMMET))
        {
          
            mdl.addSommet(me.getX(),me.getY());
        }
    }

    /**
     * évènement souris relachée
     * @param me évènement souris relachée
     */
    @Override
    public void mouseReleased(MouseEvent me) {
    
    }

    /**
     * évènement souris arrive sur une zone
     * @param me l'évènement
     */
    @Override
    public void mouseEntered(MouseEvent me) {
   
    }

    /**
     * évènement souris sort d'une zone
     * @param me l'évènement
     */
    @Override
    public void mouseExited(MouseEvent me) {
   
    }
}
