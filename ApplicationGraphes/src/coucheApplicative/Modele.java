/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coucheApplicative;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import metier.Graphe;
import metier.IConstantes;
import metier.Sommet;

/**
 *
 * @author Hans
 */
public class Modele extends Observable implements IConstantes {
//  Le graphe
    private Graphe g;
// Map de sommets avec pour clés leur nom
    private Map<String,Sommet> lesSommets;
    
    
    /**
     * Constructeur par défault
     */
    public Modele()
    {
        lesSommets=new HashMap();
        g=new Graphe();
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
    public void addSommet(int x,int y) {
        Sommet s=new Sommet();
        lesSommets.put(s.getNom(), s);
        informer(AJOUTER_SOMMET+SEPARATEUR+x+SEPARATEUR+y+SEPARATEUR+s.getNom());
    }
    
    
    
     /**
     * génère des sommets
     */
    public void generer()
    {
        informer(GENERER);
    }
    
    
}
