package beanSession;

import beanEntity.Commande;
import beanEntity.Paiement;
import java.util.Date;
import javax.ejb.Local;

@Local
public interface EJBPaiementLocal {
    
    public Paiement creerPaiement( String nomClient,float montantParMoyenTTC,Date dateHeure,String codePaiement,int numCommande);
}
