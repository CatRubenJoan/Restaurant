package beanEntity;

import beanEntity.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-10T16:56:27")
@StaticMetamodel(Statut.class)
public class Statut_ { 

    public static volatile SingularAttribute<Statut, String> id;
    public static volatile SingularAttribute<Statut, String> infoStatut;
    public static volatile CollectionAttribute<Statut, Produit> lesProduits;

}