package beanEntity;

import beanEntity.Commande;
import beanEntity.Serveur;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-11T16:28:33")
@StaticMetamodel(Emplacement.class)
public class Emplacement_ { 

    public static volatile CollectionAttribute<Emplacement, Commande> commandes;
    public static volatile SingularAttribute<Emplacement, Integer> capacite;
    public static volatile SingularAttribute<Emplacement, Serveur> serveur;
    public static volatile SingularAttribute<Emplacement, Integer> numero;
    public static volatile SingularAttribute<Emplacement, String> codeIHM;

}