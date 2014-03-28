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
import javax.swing.JTextField;
import metier.IConstantes;

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
    }

    /**
     * évènement appui sur la souri
     *
     * @param me l'évènement
     */
    @Override
    public void mousePressed(MouseEvent me) {
        if (mode.equals(MODE_SOMMET)) {

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
    public void focusGained(FocusEvent e) {
        JTextField temp = (JTextField) e.getComponent();
        nomCache = temp.getText();
        System.out.println(nomCache);
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField temp = (JTextField) e.getComponent();
        String nouv = temp.getText();
        mdl.changeName(nomCache, nouv);
        System.out.println(nouv);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getComponent() instanceof JTextField && e.getKeyCode()==KeyEvent.VK_ENTER) {
            JTextField temp = (JTextField) e.getComponent();
            temp.setFocusable(false);
            temp.setFocusable(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
