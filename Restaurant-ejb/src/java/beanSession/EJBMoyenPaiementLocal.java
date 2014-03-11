
package beanSession;

import javax.ejb.Local;


@Local
public interface EJBMoyenPaiementLocal {
    public boolean creerMoyenPaiement( String typePaiement);
}
