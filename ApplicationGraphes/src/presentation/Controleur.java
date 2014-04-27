/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import coucheApplicative.Modele;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import metier.IConstantes;
import static metier.IConstantes.MODE_ARRETE;
import static metier.IConstantes.MODE_SOMMET;

/**
 *
 * @author Hans
 */
public class Controleur implements MouseListener, ActionListener, IConstantes, FocusListener, KeyListener, MouseMotionListener {
//  le modele

    private Modele mdl;
//  le mode
    private String mode = MODE_FLECHE;
    private String nomCache;
    private IconeSommet depart;
    private IconeSommet arrive;
    private IconeSommet icoSelected = null;
    private Component lastEntered;

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
        switch (commande) {
            case MODE_SOMMET:
                mdl.modeSommet();
                this.mode = MODE_SOMMET;
                break;
            case MODE_ARRETE:
                mdl.modeArrete();
                this.mode = MODE_ARRETE;
                break;
            case MODE_FLECHE:
                mdl.modeFleche();
                this.mode = MODE_FLECHE;
                break;
            case TOUT_SUPPRIMER:
                mdl.supprimerTout();
                break;
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
        int buttonDown = me.getButton();
        if (buttonDown == MouseEvent.BUTTON3) {
            if (!mode.equals(MODE_FLECHE)) {
                mdl.modeFleche();
                this.mode = MODE_FLECHE;
            }
        } else if (mode.equals(MODE_SOMMET) && me.getComponent() instanceof VueCentre) {

            mdl.addSommet(me.getX(), me.getY());
        } else if (mode.equals(MODE_ARRETE) && me.getComponent() instanceof IconeSommet) {

            depart = (IconeSommet) me.getComponent();
            //mdl.addArreteDepart(dep);
        }



    }

    /**
     * évènement souris relachée
     *
     * @param me évènement souris relachée
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        if (mode.equals(MODE_ARRETE)) {
            if (lastEntered instanceof IconeSommet && depart != null) {
                arrive = (IconeSommet) lastEntered;
                if (arrive != depart) {
                    mdl.addArrete(depart, arrive);
                }
                arrive = null;
            }
            depart = null;
            mdl.masquerArreteTemp();
        }

    }

    /**
     * évènement souris arrive sur une zone
     *
     * @param me l'évènement
     */
    @Override
    public void mouseEntered(MouseEvent me) {
        lastEntered = me.getComponent();
    }

    /**
     * évènement souris sort d'une zone
     *
     * @param me l'évènement
     */
    @Override
    public void mouseExited(MouseEvent me) {
    }

    /**
     *
     * @param e
     */
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
            if (mode.equals(MODE_FLECHE)) {
                icoSelected = (IconeSommet) e.getComponent();
                nomCache = icoSelected.getTextField().getText();
                mdl.modeSelectionSommet(icoSelected.getLabel().getText());

            }
        }

    }

    /**
     *
     * @param e
     */
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
        } else if (e.getComponent() instanceof IconeSommet) {
            if (mode.equals(MODE_FLECHE)) {
                IconeSommet tmp = (IconeSommet) e.getComponent();
                System.err.println("focus lost de " + tmp.getLabel().getText());
                mdl.modeNonSelectionSommet(tmp.getLabel().getText());
                icoSelected = null;
            }

        }

    }

    /**
     *
     * @param e
     */
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
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {

            if (mode.equals(MODE_FLECHE)) {

                if (icoSelected != null) {

                    mdl.supprimerSommet(icoSelected);
                    icoSelected = null;
                }
            }

        }

    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (depart != null && mode == MODE_ARRETE) {
            int x1, x2, y1, y2;
            x1 = depart.getCentreX();
            y1 = depart.getCentreY();
            x2 = e.getX() + depart.getOrigineX();
            y2 = e.getY() + depart.getOrigineY();

            mdl.afficheArreteTemporaire(x1, y1, x2, y2);

        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
