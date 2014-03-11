
package beanSession;

import beanEntity.MoyenPaiement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EJBMoyenPaiement implements EJBMoyenPaiementLocal {
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public boolean creerMoyenPaiement( String typePaiement){
        
      boolean test = false;
        
        if(em.find(EJBMoyenPaiement.class, typePaiement)==null)
        {
            MoyenPaiement mp1 = new MoyenPaiement( typePaiement);
            em.persist(mp1);
            test = true;
        }
        
        return test;

        
    }

   
}
