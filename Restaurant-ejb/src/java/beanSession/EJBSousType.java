/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Produit;
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
                entree.getLesSousType().add(entFr);
                em.persist(entFr);
            }
            if (em.find(SousType.class, "ENTCH") == null) {
                SousType entCh = new SousType("ENTCH", "Entrées Chaudes", entree);
                entree.getLesSousType().add(entCh);
                em.persist(entCh);
            }
        }
        if (em.find(Type.class, "PLA") != null) {
            Type plat = em.find(Type.class, "PLA");
            if (em.find(SousType.class, "POI") == null) {
                SousType poi = new SousType("POI", "Poissons", plat);
                plat.getLesSousType().add(poi);
                em.persist(poi);
            }
            if (em.find(SousType.class, "VIA") == null) {
                SousType via = new SousType("VIA", "Viandes", plat);
                plat.getLesSousType().add(via);
                em.persist(via);
            }
            if (em.find(SousType.class, "PAT") == null) {
                SousType pat = new SousType("PAT", "Pâte", plat);
                plat.getLesSousType().add(pat);
                em.persist(pat);
            }
        }
        if (em.find(Type.class, "DES") != null) {
            Type des = em.find(Type.class, "DES");
            if (em.find(SousType.class, "TAR") == null) {
                SousType tar = new SousType("TAR", "Tartes", des);
                des.getLesSousType().add(tar);
                em.persist(tar);
            }
            if (em.find(SousType.class, "GLA") == null) {
                SousType gla = new SousType("GLA", "Glaces", des);
                des.getLesSousType().add(gla);
                em.persist(gla);
            }
        }
        if (em.find(Type.class, "BOI") != null) {
            Type boi = em.find(Type.class, "BOI");
            if (em.find(SousType.class, "VIN") == null) {
                SousType vin = new SousType("VIN", "Vins", boi);
                boi.getLesSousType().add(vin);
                em.persist(vin);
            }
            if (em.find(SousType.class, "COCK") == null) {
                SousType cock = new SousType("COCK", "Cocktail", boi);
                boi.getLesSousType().add(cock);
                em.persist(cock);
            }
        }
    }

    @Override
    public boolean ajouterSousType(String id, String lib, String type) {
        boolean test = false;

        if (em.find(Type.class, type) != null) {
            Type t = em.find(Type.class, type);
            if (em.find(SousType.class, id) == null) {
                SousType st1 = new SousType(id, lib, t);
                t.getLesSousType().add(st1);
                em.persist(st1);
                test = true;
            }
        }
        return test;
    }

    @Override
    public boolean modifierSousType(String id, String lib) {
        boolean test = false;

        if (em.find(SousType.class, id) != null) {
            SousType s1 = em.find(SousType.class, id);
            s1.setInfoSousType(lib);
            em.merge(s1);
            test = true;
        }
        return test;
    }

    @Override
    public boolean modifierSousType(String id, String lib, String type) {
        boolean test = false;
        if (em.find(Type.class, type) != null) {
            Type t = em.find(Type.class, type);
            if (em.find(SousType.class, id) != null) {
                SousType s1 = em.find(SousType.class, id);
                s1.setInfoSousType(lib);
                s1.getType().getLesSousType().remove(s1);
                s1.setType(t);
                t.getLesSousType().add(s1);
                em.merge(s1);
                test = true;
            }
        }
        return test;
    }

    @Override
    public boolean supprimerSousType(String id) {
        boolean test = false;

        if (em.find(SousType.class, id) != null) {
            SousType s = em.find(SousType.class, id);
            for (Produit p : s.getLesProduits()) {
                p.setSousType(null);
                em.merge(p);
            }
            em.remove(s);
            test = true;
        }
        return test;
    }

    @Override
    public SousType unSousType(String id) {
        SousType s = em.find(SousType.class, id);
        return s;
    }
}
