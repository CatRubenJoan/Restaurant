/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Promotion;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi412
 */
@Stateless
public class EJBPromotion implements EJBPromotionLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    EntityManager em;

    @Override
    public Promotion creerPromotion(float taux, Date dateDebut, Date dateFin) {
        Promotion p1 = new Promotion(taux, dateDebut, dateFin);
        em.persist(p1);
        return p1;
    }

    @Override
    public Promotion unePromotion(int id) {
        Promotion p = em.find(Promotion.class, id);
        return p;
    }

    @Override
    public Collection<Promotion> lesPromotions(Date date) {
        String texteRequête = "SELECT promotion "
                + "FROM Promotion AS promotion "
                + "WHERE ?1 BETWEEN promotion.dateDebut AND promotion.dateFin";
        Query requête = em.createQuery(texteRequête);
        requête.setParameter(1, date);
        return requête.getResultList();
    }
}