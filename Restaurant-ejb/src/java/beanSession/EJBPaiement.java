
package beanSession;

import beanEntity.Commande;
import beanEntity.MoyenPaiement;
import beanEntity.Paiement;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EJBPaiement implements EJBPaiementLocal {
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    @Override
    public boolean creerPaiement( String nomClient,float montantParMoyenTTC,Date dateHeure){

    boolean test = true;
         
            Paiement mp = new Paiement(nomClient, montantParMoyenTTC,dateHeure);
            em.persist(mp);
            test=true;
            return test;
        
        
    
}
    
}
