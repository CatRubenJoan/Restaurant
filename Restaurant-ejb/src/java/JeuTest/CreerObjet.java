/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JeuTest;

import beanEntity.Cuisinier;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreerObjet {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurant-ejbPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;
        
//        Cuisinier c1 = new Cuisinier(2, "Bouh");
        
        et = em.getTransaction();
        et.begin();
//        em.persist(c1);
        et.commit();
        
        em.close();
        emf.close();        
    }
}
