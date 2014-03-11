package beanEntity;

import beanEntity.SousType;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-11T16:28:33")
@StaticMetamodel(Type.class)
public class Type_ { 

    public static volatile SingularAttribute<Type, String> id;
    public static volatile SingularAttribute<Type, String> infoType;
    public static volatile CollectionAttribute<Type, SousType> lesSousType;

}