/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Cuisinier;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi412
 */
@Stateless
public class EJBCuisinier implements EJBCuisinierLocal {
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;
    
    @Override
    public boolean creerCuisinier(String codeIHM, String nom) {
        boolean test = false;
        
        if(em.find(Cuisinier.class, codeIHM)==null)
        {
            Cuisinier c1 = new Cuisinier(codeIHM, nom);
            em.persist(c1);
            test = true;
        }
        
        return test;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Cuisinier unCuisinier(String code) {
        Cuisinier c = em.find(Cuisinier.class, code);
        return c;
    }

}
