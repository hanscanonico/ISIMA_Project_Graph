/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coucheApplicative;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import metier.Arrete;
import metier.Graphe;
import metier.IConstantes;
import static metier.IConstantes.ARRETE_TEMP;
import static metier.IConstantes.CHANGER_NOM;
import static metier.IConstantes.MODE_NON_SELECTION_SOMMET;
import static metier.IConstantes.SEPARATEUR;
import static metier.IConstantes.SUPPRIMER_SOMMET;
import metier.Sommet;
import presentation.IconeSommet;

/**
 *
 * @author Hans
 */
public class Modele extends Observable implements IConstantes {
//  Le graphe

    private Graphe g;
// Map de sommets avec pour clés leur nom
    private Map<String, Sommet> lesSommets;
// Map de iconeArrete avec pour clé la concatéantion du nom des 2 sommets de chaque extrémité
    private Map<String, Arrete> lesArretes;
    /**
     *
     */
    public static int i = 0;

    /**
     * Constructeur par défault
     */
    public Modele() {
        lesSommets = new HashMap();
        lesArretes = new HashMap();
        g = new Graphe();
    }

    /**
     * informe la vue de passer en mode sommet
     */
    public void modeSommet() {
        informer(MODE_SOMMET);
    }

    /**
     * informe la vue de passer en mode arrête
     */
    public void modeArrete() {
        informer(MODE_ARRETE);
    }

    /**
     * informe la vue de passer en mode par default
     */
    public void modeFleche() {
        informer(MODE_FLECHE);
    }

    /**
     * informe la vue d'un changement
     *
     * @param changement le changement
     */
    public void informer(String changement) {
        setChanged();
        notifyObservers(changement);
    }

    /**
     *
     * @param x la coordonnée x du curseur
     * @param y la coordonnée y du curseur
     */
    public void addSommet(int x, int y) {
        Sommet s = new Sommet(Integer.toString(i));
        i++;
        lesSommets.put(s.getNom(), s);
        informer(AJOUTER_SOMMET + SEPARATEUR + x + SEPARATEUR + y + SEPARATEUR + s.getNom());
    }

    /**
     * génère des sommets
     */
    public void supprimerTout() {
        lesSommets.clear();
        lesArretes.clear();
        i = 0;

        informer(TOUT_SUPPRIMER);
    }

    /**
     *
     * @param nomCache
     * @param nouv
     */
    public void changeName(String nomCache, String nouv) {

        //evite d'avoir 2 sommet ayant le meme nom
        if (this.lesSommets.containsKey(nouv)) {
            nouv = nomCache;
        }

        Sommet tmp = this.lesSommets.get(nomCache);
        tmp.setNom(nouv);
        lesSommets.remove(nomCache);
        lesSommets.put(nouv, tmp);
        informer(CHANGER_NOM + SEPARATEUR + nomCache + SEPARATEUR + nouv);



    }

    /**
     *
     * @param nomCache
     */
    public void afficheTextfield(String nomCache) {
        informer(AFFICHE_TEXTF + SEPARATEUR + nomCache);
    }

    /**
     *
     * @param nomCache
     */
    public void modeSelectionSommet(String nomCache) {
        informer(MODE_SELECTION_SOMMET + SEPARATEUR + nomCache);
    }

    /**
     *
     * @param nomCache
     */
    public void modeNonSelectionSommet(String nomCache) {
        informer(MODE_NON_SELECTION_SOMMET + SEPARATEUR + nomCache);
    }

    /**
     *
     * @param depart
     * @param arrive
     */
    public void addArrete(IconeSommet depart, IconeSommet arrive) {
        Sommet s1, s2;
        s1 = lesSommets.get(depart.getNom());
        s2 = lesSommets.get(arrive.getNom());
        Arrete nouv = new Arrete(s1, s2);

        String doubleCle, doubleCleMiroir, cle1, cle2;
        cle1 = Integer.toString(s1.hashCode());
        cle2 = Integer.toString(s2.hashCode());
        doubleCle = cle1 + "/" + cle2;
        doubleCleMiroir = cle2 + "/" + cle1;

        if (!lesArretes.containsKey(doubleCle) && !lesArretes.containsKey(doubleCleMiroir)) {
            lesArretes.put(doubleCle, nouv);
            informer(AJOUTER_ARRETE + SEPARATEUR + depart.getNom() + SEPARATEUR + arrive.getNom());
        }

    }

    /**
     * permet de supprimer un sommet
     *
     * @param icoSommet le sommet a suppriemr
     */
    public void supprimerSommet(IconeSommet icoSommet) {
        Sommet s = lesSommets.remove(icoSommet.getTextField().getText());
        for (Arrete a : lesArretes.values()) {
            if (a.getSommet1() == s || a.getSommet2() == s) {
            }
        }
        informer(SUPPRIMER_SOMMET + SEPARATEUR + icoSommet.getTextField().getText());

    }

    public void afficheArreteTemporaire(int x1, int y1, int x2, int y2) {
        informer(ARRETE_TEMP + SEPARATEUR + x1 + SEPARATEUR + y1 + SEPARATEUR + x2 + SEPARATEUR + y2);

    }

    public void masquerArreteTemp() {
        informer(MASQUER_TEMP);
    }
}
