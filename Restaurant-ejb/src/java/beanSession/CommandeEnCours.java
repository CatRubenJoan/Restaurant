package beanSession;

import beanEntity.Commande;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Stateless
public class CommandeEnCours implements CommandeEnCoursLocal {
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public boolean creerCommandeBidon(String numCommande, Date dateHeure, int nbPersonne){
        Commande c = new Commande(numCommande, dateHeure, nbPersonne);
//        EntityTransaction et = em.getTransaction();
//        et.begin();
        em.persist(c);
//        em.close();
        
        return false;
    }
    @Override
    public boolean creerCommandeBidon(Date dateHeure, int nbPersonne){
        Commande c = new Commande(dateHeure, nbPersonne);
//        EntityTransaction et = em.getTransaction();
//        et.begin();
        em.persist(c);
//        em.close();
        
        return false;
    }
}
