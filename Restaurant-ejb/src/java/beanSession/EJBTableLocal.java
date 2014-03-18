package beanSession;

import beanEntity.Commande;
import javax.ejb.Local;

@Local
public interface EJBTableLocal {

    public Commande installerATable(int noTable, int nbPersonnes);
    
}
