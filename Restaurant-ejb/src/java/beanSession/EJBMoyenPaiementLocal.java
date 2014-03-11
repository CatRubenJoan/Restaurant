
package beanSession;

import javax.ejb.Local;


@Local
public interface EJBMoyenPaiementLocal {
    public void creerMoyenPaiement();
    public boolean ajouterMoyenPaiement(String codePaiement, String typePaiement);
}
