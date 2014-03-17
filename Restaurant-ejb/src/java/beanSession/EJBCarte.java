package beanSession;

import beanEntity.Produit;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EJBCarte implements EJBCarteLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public Collection<Produit> listeProduitsParCat(String idSousType) {
        String req = "SELECT p FROM PRODUIT p WHERE p.DISPONIBILITE = :paramID1 AND p.SOUSTYPE_ID";
        Query qr = em.createQuery(req);
        qr.setParameter("paramID1", true);
        qr.setParameter("paramID2", idSousType);
        Collection<Produit> carte = (ArrayList) qr.getResultList();
        return carte;
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
