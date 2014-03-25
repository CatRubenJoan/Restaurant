package beanSession;

import beanEntity.TVA;
import javax.ejb.Local;

@Local
public interface EJBTVALocal {

    public void persist(Object object);

    public boolean creerTVA(float f);

    public boolean modifierTVA(float gam, float ny);

    public boolean supprimerTVA(float f);

    public TVA uneTVA(String tx);
    
}
