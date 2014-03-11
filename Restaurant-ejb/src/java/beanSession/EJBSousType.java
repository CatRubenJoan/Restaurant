/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.SousType;
import beanEntity.Type;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi412
 */
@Stateless
public class EJBSousType implements EJBSousTypeLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    EntityManager em;

    @Override
    public void creerSousType() {
        if (em.find(Type.class, "ENT") != null) {
            Type entree = em.find(Type.class, "ENT");
            if (em.find(SousType.class, "ENTFR") == null) {
                SousType entFr = new SousType("ENTFR", "Entrées Froides", entree);
                em.persist(entFr);
            }
            if (em.find(SousType.class, "ENTCH") == null) {
                SousType entCh = new SousType("ENTCH", "Entrées Chaudes", entree);
                em.persist(entCh);
            }
        }
        if (em.find(Type.class, "PLA") != null) {
            Type plat = em.find(Type.class, "PLA");
            if (em.find(SousType.class, "POI") == null) {
                SousType poi = new SousType("POI", "Poissons", plat);
                em.persist(poi);
            }
            if (em.find(SousType.class, "VIA") == null) {
                SousType via = new SousType("VIA", "Viandes", plat);
                em.persist(via);
            }
        }
        if (em.find(Type.class, "PLA") != null) {
            Type plat = em.find(Type.class, "PLA");
            if (em.find(SousType.class, "PAT") == null) {
                SousType pat = new SousType("PAT", "Pâte", plat);
                em.persist(pat);
            }
            if (em.find(SousType.class, "VIA") == null) {
                SousType via = new SousType("VIA", "Viandes", plat);
                em.persist(via);
            }
        }
        if (em.find(Type.class, "DES") != null) {
            Type des = em.find(Type.class, "DES");
            if (em.find(SousType.class, "TAR") == null) {
                SousType tar = new SousType("TAR", "Tartes", des);
                em.persist(tar);
            }
            if (em.find(SousType.class, "GLA") == null) {
                SousType gla = new SousType("GLA", "Glaces", des);
                em.persist(gla);
            }
        }
        if (em.find(Type.class, "BOI") != null) {
            Type boi = em.find(Type.class, "BOI");
            if (em.find(SousType.class, "VIN") == null) {
                SousType vin = new SousType("VIN", "Vins", boi);
                em.persist(vin);
            }
            if (em.find(SousType.class, "COCK") == null) {
                SousType cock = new SousType("COCK", "Cocktail", boi);
                em.persist(cock);
            }
        }
    }

    @Override
    public boolean ajouterSousType(String id, String lib, Type tp) {
        boolean test = false;

        if (em.find(SousType.class, id) == null) {
            SousType st1 = new SousType(id, lib, tp);
            em.persist(st1);
            test = true;
        }
        return test;
    }
}
