/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Type;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi412
 */
@Stateless
public class EJBType implements EJBTypeLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    EntityManager em;

    @Override
    public void creerType() {
        if (em.find(Type.class, "ENT") == null) {
            Type entree = new Type("ENT", "Entrée");
            em.persist(entree);
        }
        if (em.find(Type.class, "PLA") == null) {
            Type plat = new Type("PLA", "Plat");
            em.persist(plat);
        }
        if (em.find(Type.class, "DES") == null) {
            Type dessert = new Type("DES", "Dessert");
            em.persist(dessert);
        }
        if (em.find(Type.class, "BOI") == null) {
            Type boisson = new Type("BOI", "Boisson");
            em.persist(boisson);
        }
    }

    @Override
    public boolean ajouterType(String id, String lib) {
        boolean test = false;

        if (em.find(Type.class, id) == null) {
            Type t1 = new Type(id, lib);
            em.persist(t1);
            test = true;
        }
        return test;
    }

    @Override
    public boolean modifierType(String id, String lib) {
        boolean test = false;

        if (em.find(Type.class, id) != null) {
            Type t1 = em.find(Type.class, id);
            t1.setInfoType(lib);
            em.merge(t1);
            test = true;
        }
        return test;
    }

    @Override
    public boolean supprimerType(String id) {
        boolean test = false;

        if (em.find(Type.class, id) != null) {
            Type t1 = em.find(Type.class, id);
            em.remove(t1);
            test = true;
        }
        return test;
    }

//    @Override
//    public Type unType(String id) {
//        
//    }
}
