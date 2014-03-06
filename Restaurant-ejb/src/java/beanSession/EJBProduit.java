/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Produit;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi412
 */
@Stateless
public class EJBProduit implements EJBProduitLocal {
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    EntityManager em;
    
    @Override
    public boolean creerProduit(String ref, String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt)
    {
        boolean test = false;
        
        if(em.find(Produit.class, ref)==null)
        {
            Produit p1 = new Produit(ref,nom, composition, qualiteNutritive, historique, disponibilite, prixHt);
            em.persist(p1);
            test = true;
        }
        
        return test;
    }
}
