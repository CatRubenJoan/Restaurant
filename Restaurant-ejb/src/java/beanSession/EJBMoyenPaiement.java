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
    public void creerMoyenPaiement() {
       
        if (em.find(MoyenPaiement.class, "ES") == null) {
       MoyenPaiement mp=new MoyenPaiement("ES", "espèces"); 
       em.persist(mp);
      
        }
         if (em.find(MoyenPaiement.class, "CH") == null) {
       MoyenPaiement mp=new MoyenPaiement("CH", "chèque"); 
       em.persist(mp);
      
        }
          if (em.find(MoyenPaiement.class, "CB") == null) {
       MoyenPaiement mp=new MoyenPaiement("CB", "carte bancaire"); 
       em.persist(mp);
      
        }
    
    }
    @Override
 public boolean ajouterMoyenPaiement(String codePaiement, String typePaiement){   
    
     boolean test = false;
        if (em.find(MoyenPaiement.class, codePaiement) == null) {
            MoyenPaiement mp = new MoyenPaiement(codePaiement, typePaiement);
            em.persist(mp);
            test=true;
            return test;
        }
        return test;
    
  
 }   
}