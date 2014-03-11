package beanEntity;

import beanEntity.Produit;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-11T16:28:33")
@StaticMetamodel(Promotion.class)
public class Promotion_ { 

    public static volatile SingularAttribute<Promotion, Integer> id;
    public static volatile CollectionAttribute<Promotion, Produit> lesProduits;
    public static volatile SingularAttribute<Promotion, Date> dateFin;
    public static volatile SingularAttribute<Promotion, Float> tauxPromotion;
    public static volatile SingularAttribute<Promotion, Date> dateDebut;

}