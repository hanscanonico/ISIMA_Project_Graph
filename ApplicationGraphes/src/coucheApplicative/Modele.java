/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coucheApplicative;

import java.util.Observable;
import metier.Graphe;
import metier.IConstantes;

/**
 *
 * @author Hans
 */
public class Modele extends Observable implements IConstantes{
    Graphe g;

    public void modeSommet() {
       informer(MODE_SOMMET);
    }
    
    public void modeArrete() {
        informer(MODE_ARRETE);    
    }

    public void modeFleche() {
        informer(MODE_FLECHE);    
    }
    
    public void informer(String changement)
    {
        setChanged();
        notifyObservers(changement);
    }


}
