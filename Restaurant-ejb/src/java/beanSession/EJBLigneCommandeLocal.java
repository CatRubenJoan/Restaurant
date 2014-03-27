package beanSession;

import beanEntity.Commande;
import beanEntity.LigneCommande;
import beanEntity.Produit;
import javax.ejb.Local;

@Local
public interface EJBLigneCommandeLocal {

    public Commande modificationLigneCommande(LigneCommande lc2change, LigneCommande lcny);

    public Commande ajoutLigneCommande(String noCommande, int qte, float prixHTLC, String commentaire, String noPRoduit);
    
}
