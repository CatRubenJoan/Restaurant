/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Cuisinier;
import beanEntity.Produit;
import beanEntity.SousType;
import beanEntity.Statut;
import java.util.ArrayList;
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
    public boolean creerProduit(String ref, String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, SousType sousType) {
        boolean test = false;

        if (em.find(Produit.class, ref) == null) {
            Produit p1 = new Produit(ref, nom, composition, qualiteNutritive, historique, disponibilite, prixHt, sousType);
            em.merge(p1);

            test = true;
        }
        return test;
    }

    @Override
    public boolean creerProduit(String ref, String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, String sousTypeId) {
        boolean test = false;
        SousType s1 = null;
        if (em.find(SousType.class, sousTypeId) != null) {
            s1 = em.find(SousType.class, sousTypeId);
        }
        if ((em.find(Produit.class, ref) == null) && (s1!=null)) {
            Produit p1 = new Produit(ref, nom, composition, qualiteNutritive, historique, disponibilite, prixHt, s1);
            em.merge(p1);

            test = true;
        }
        return test;
    }

    @Override
    public boolean attribuerCuisinier(String p, String c) {
        boolean test = false;

        if ((em.find(Produit.class, p) != null) && (em.find(Cuisinier.class, c) != null)) {
            Produit p1 = em.find(Produit.class, p);
            Cuisinier c1 = em.find(Cuisinier.class, c);
            p1.setCuisto(c1);
            em.merge(p1);

            test = true;
        }
        return test;
    }

    @Override
    public boolean attribuerPromotion(String prod, String promo) {
        boolean test = false;

        return test;
    }

    @Override
    public boolean attribuerPromotion(ArrayList prod, String promo) {
        boolean test = false;

        return test;
    }
}
