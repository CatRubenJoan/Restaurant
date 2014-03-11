/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Promotion;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi412
 */
@Stateless
public class EJBPromotion implements EJBPromotionLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    EntityManager em;

    @Override
    public void creerPromotion(float taux, Date dateDebut, Date dateFin) {
        Promotion p1 = new Promotion(taux, dateDebut, dateFin);
        em.persist(p1);
    }
}
