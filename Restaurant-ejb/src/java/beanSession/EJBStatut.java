/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Statut;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi412
 */
@Stateless
public class EJBStatut implements EJBStatutLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    EntityManager em;

    @Override
    public void creerStatut() {
        if (em.find(Statut.class, "AUCUN") == null) {
            Statut aucun = new Statut("AUCUN", "Aucun");
            em.persist(aucun);
        }
        if (em.find(Statut.class, "TRANS") == null) {
            Statut transmis = new Statut("TRANS", "Transmis en cuisine");
            em.persist(transmis);

        }
        if (em.find(Statut.class, "PREPA") == null) {
            Statut prepa = new Statut("PREPA", "En préparation");
            em.persist(prepa);
        }

        if (em.find(Statut.class, "PRET") == null) {
            Statut pret = new Statut("PRET", "Prêt");
            em.persist(pret);
        }
    }

    @Override
    public boolean ajouterStatut(String id, String lib) {
        boolean test = false;

        if (em.find(Statut.class, id) == null) {
            Statut s1 = new Statut(id, lib);
            em.persist(s1);
            test = true;
        }

        return test;
    }
}
