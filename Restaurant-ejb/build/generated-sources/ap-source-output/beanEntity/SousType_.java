package beanEntity;

import beanEntity.Produit;
import beanEntity.Type;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-11T16:28:33")
@StaticMetamodel(SousType.class)
public class SousType_ { 

    public static volatile SingularAttribute<SousType, String> id;
    public static volatile SingularAttribute<SousType, String> infoSousType;
    public static volatile CollectionAttribute<SousType, Produit> lesProduits;
    public static volatile SingularAttribute<SousType, Type> type;

}