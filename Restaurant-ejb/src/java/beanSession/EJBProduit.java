/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Cuisinier;
import beanEntity.Produit;
import beanEntity.Promotion;
import beanEntity.SousType;
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
    public Produit creerProduit(String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, SousType sousType) {
        Produit p1 = new Produit(nom, composition, qualiteNutritive, historique, disponibilite, prixHt, sousType);
        sousType.getLesProduits().add(p1);
        em.merge(sousType);
        em.persist(p1);

        return p1;
    }

    @Override
    public Produit creerProduit(String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, String sousTypeId) {

        SousType s1 = em.find(SousType.class, sousTypeId);
        Produit p1 = new Produit(nom, composition, qualiteNutritive, historique, disponibilite, prixHt, s1);
        s1.getLesProduits().add(p1);
        em.merge(s1);
        em.persist(p1);

        return p1;
    }

    @Override
    public boolean attribuerCuisinier(String p, String c) {
        boolean test = false;

        if ((em.find(Produit.class, p) != null) && (em.find(Cuisinier.class, c) != null)) {
            Produit p1 = em.find(Produit.class, p);
            Cuisinier c1 = em.find(Cuisinier.class, c);
            c1.getLesProduits().add(p1);
            p1.setCuisto(c1);
            em.merge(c1);
            em.merge(p1);

            test = true;
        }
        return test;
    }

    @Override
    public boolean attribuerPromotion(String prod, int promo) {
        boolean test = false;

        if ((em.find(Produit.class, prod) != null) && (em.find(Promotion.class, promo) != null)) {
            Produit p1 = em.find(Produit.class, prod);
            Promotion pr1 = (em.find(Promotion.class, promo));
            pr1.getLesProduits().add(p1);
            p1.setPromo(pr1);
            em.merge(pr1);
            em.merge(p1);

            test = true;
        }
        return test;
    }

    @Override
    public boolean attribuerPromotion(ArrayList<Produit> prod, int promo) {
        boolean test = false;

        if (em.find(Promotion.class, promo) != null) {
            Promotion pr1 = (em.find(Promotion.class, promo));
            for (Produit p : prod) {
                pr1.getLesProduits().add(p);
                p.setPromo(pr1);
                em.merge(pr1);
                em.merge(p);
            }
            test = true;
        }
        return test;
    }
}
