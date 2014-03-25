package beanSession;

import beanEntity.TVA;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJBTVA implements EJBTVALocal {
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public boolean creerTVA(float f){
        boolean ok = false;
        if(em.find(TVA.class, f) == null){
            TVA newTVA = new TVA(f);
            em.persist(newTVA);
            ok = true;
        }
        return ok;
    }
        
    @Override
    public boolean modifierTVA(float gam, float ny){
        boolean ok = false;
        if(em.find(TVA.class, gam) == null){
            TVA newTVA = new TVA(ny);
            em.persist(newTVA);
            ok = true;
        }else{
            TVA toMod = em.find(TVA.class, gam);
            toMod.setTaux(ny);
            em.merge(toMod);
        }
        return ok;
    }    
    
    @Override
    public boolean supprimerTVA(float f){
        boolean ok = false;
        if(em.find(TVA.class, f) != null){
            TVA toDel = new TVA(f);
            em.remove(toDel);
            ok = true;
        }
        return ok;
    }       
   
    @Override
    public TVA uneTVA(String tx) {
        TVA tva = em.find(TVA.class, tx);
        return tva;
    }    
    
}
