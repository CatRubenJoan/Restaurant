package beanEntity;

import beanEntity.Emplacement;
import beanEntity.LigneCommande;
import beanEntity.Paiement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-11T16:28:33")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Integer> numCommande;
    public static volatile CollectionAttribute<Commande, LigneCommande> lignesCommande;
    public static volatile SingularAttribute<Commande, Date> dateHeure;
    public static volatile SingularAttribute<Commande, Emplacement> table;
    public static volatile SingularAttribute<Commande, Integer> nbPersonne;
    public static volatile CollectionAttribute<Commande, Paiement> paiements;

}