/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import coucheApplicative.Modele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import metier.IConstantes;
import static metier.IConstantes.MODE_SOMMET;

/**
 *
 * @author Hans
 */
public class Controleur implements MouseListener, ActionListener, IConstantes, FocusListener, KeyListener {
//  le modele

    private Modele mdl;
//  le mode
    private String mode = MODE_FLECHE;
    private String nomCache;
    
    /**
     * Constructeur
     *
     * @param mdl le modele
     */
    public Controleur(Modele mdl) {

        this.mdl = mdl;
    }

    /**
     * evenements boutons
     *
     * @param ae l'évènement
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String commande = ae.getActionCommand();
        if (commande.equals(MODE_SOMMET)) {
            mdl.modeSommet();
            this.mode = MODE_SOMMET;
        } else if (commande.equals(MODE_ARRETE)) {
            mdl.modeArrete();
            this.mode = MODE_ARRETE;
        } else if (commande.equals(MODE_FLECHE)) {
            mdl.modeFleche();
            this.mode = MODE_FLECHE;
        } else if (commande.equals(GENERER)) {
            mdl.generer();
        }
    }

    /**
     * evenement clique de souris
     *
     * @param me l'évènement
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        
        if (mode.equals(MODE_FLECHE)) {

            if (me.getComponent() instanceof JLabel) {
                JLabel tmp = (JLabel) me.getComponent();
                mdl.afficheTextfield(tmp.getText());
            }
           
        }
    }

    /**
     * évènement appui sur la souri
     *
     * @param me l'évènement
     */
    @Override
    public void mousePressed(MouseEvent me) {
        me.getComponent().requestFocus();
        if (mode.equals(MODE_SOMMET) && me.getComponent() instanceof JPanel) {

            mdl.addSommet(me.getX(), me.getY());
        }

    }

    /**
     * évènement souris relachée
     *
     * @param me évènement souris relachée
     */
    @Override
    public void mouseReleased(MouseEvent me) {
    }

    /**
     * évènement souris arrive sur une zone
     *
     * @param me l'évènement
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }

    /**
     * évènement souris sort d'une zone
     *
     * @param me l'évènement
     */
    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    /**
     * Quand un text field recoit le focus
     *
     * @param e l'évènement
     */
    public void focusGained(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            JTextField temp = (JTextField) e.getComponent();
            nomCache = temp.getText();
            System.out.println(nomCache);
        } 
         if (e.getComponent() instanceof IconeSommet) {
                 IconeSommet tmp=(IconeSommet) e.getComponent();
                 mdl.modeSelectionSommet(tmp.getLabel().getText());
         }

    }

    @Override
     /**
     * Quand un text field perd le focus
     *
     * @param e l'évènement
     */
    public void focusLost(FocusEvent e) {
        if (e.getComponent() instanceof JTextField) {
            JTextField temp = (JTextField) e.getComponent();
            String nouv = temp.getText();
            mdl.changeName(nomCache, nouv);
            System.out.println(nouv);
        }
        else if (e.getComponent() instanceof IconeSommet) {
          IconeSommet tmp=(IconeSommet) e.getComponent();
          mdl.modeNonSelectionSommet(tmp.getLabel().getText());
        }

    }


    @Override
     /**
     * Quand une touche du claiver est pressée
     *
     * @param e l'évènement
     */
    public void keyPressed(KeyEvent e) {
        if (e.getComponent() instanceof JTextField && e.getKeyCode() == KeyEvent.VK_ENTER) {
            JTextField temp = (JTextField) e.getComponent();
            temp.setFocusable(false);
            temp.setFocusable(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
