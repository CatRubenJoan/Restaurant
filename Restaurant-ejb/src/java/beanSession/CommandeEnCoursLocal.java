package beanSession;

import beanEntity.Commande;
import java.util.Date;
import javax.ejb.Local;

@Local
public interface CommandeEnCoursLocal {

    public boolean creerCommandeBidon(String numCommande, Date dateHeure, int nbPersonne);
    public boolean creerCommandeBidon(Date dateHeure, int nbPersonne);


    
}
