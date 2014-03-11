package beanEntity;

import beanEntity.Emplacement;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-11T16:28:33")
@StaticMetamodel(Serveur.class)
public class Serveur_ { 

    public static volatile CollectionAttribute<Serveur, Emplacement> tables;
    public static volatile SingularAttribute<Serveur, String> nom;
    public static volatile SingularAttribute<Serveur, String> codeIHM;

}