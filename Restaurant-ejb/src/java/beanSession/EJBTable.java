package beanSession;

import beanEntity.Commande;
import beanEntity.Emplacement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EJBTable implements EJBTableLocal {

    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    //a accomplir par un employé pour chaque commande
    @Override
    public Commande installerATable(int noTable, int nbPersonnes) {
        Emplacement table = em.find(Emplacement.class, noTable);
        Commande c = new Commande(new GregorianCalendar().getInstance().getTime(), nbPersonnes, em.find(Emplacement.class, noTable));
        return c;
    }
    
    //pb: comment determiner si la commande est en cours ou pas?
//    public Collection<Commande> listeCommandesParTable(int noTable){
//        Emplacement table = em.find(Emplacement.class, noTable);
//        Collection<Commande> listeDesCommandes = new ArrayList();
//        String req = "SELECT c FROM COMMANDE c WHERE c.TABLE = :paramID";
//        Query qr = em.createQuery(req);
//        qr.setParameter("paramID", noTable);
//        listeDesCommandes = qr.getResultList();
//        return listeDesCommandes;             
//    } 

    public void persist(Object object) {
        em.persist(object);
    }
}
