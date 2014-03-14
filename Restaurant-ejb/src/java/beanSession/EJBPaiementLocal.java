package beanSession;

import beanEntity.Commande;
import java.util.Date;
import javax.ejb.Local;

@Local
public interface EJBPaiementLocal {
    
    public boolean creerPaiement( String nomClient,float montantParMoyenTTC,Date dateHeure);
}
