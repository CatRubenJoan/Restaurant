/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import javax.ejb.Local;

/**
 *
 * @author cdi412
 */
@Local
public interface EJBProduitLocal {
    public boolean creerProduit(String ref, String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt);
}
