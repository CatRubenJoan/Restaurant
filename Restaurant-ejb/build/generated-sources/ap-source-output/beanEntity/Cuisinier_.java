package beanEntity;

import beanEntity.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-10T16:56:27")
@StaticMetamodel(Cuisinier.class)
public class Cuisinier_ { 

    public static volatile CollectionAttribute<Cuisinier, Produit> lesProduits;
    public static volatile SingularAttribute<Cuisinier, String> nom;
    public static volatile SingularAttribute<Cuisinier, String> codeIHM;

}