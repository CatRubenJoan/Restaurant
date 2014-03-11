package beanEntity;

import beanEntity.Cuisinier;
import beanEntity.Promotion;
import beanEntity.SousType;
import beanEntity.Statut;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-10T16:56:27")
=======
@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-10T11:19:28")
>>>>>>> b90473712969da56669e7ea272804df9b6e0e809
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Statut> infoStatut;
    public static volatile SingularAttribute<Produit, String> historique;
    public static volatile SingularAttribute<Produit, Boolean> disponibilite;
    public static volatile SingularAttribute<Produit, Promotion> promo;
    public static volatile SingularAttribute<Produit, SousType> sousType;
    public static volatile SingularAttribute<Produit, String> composition;
    public static volatile SingularAttribute<Produit, Cuisinier> cuisto;
    public static volatile SingularAttribute<Produit, String> qualiteNutritive;
    public static volatile SingularAttribute<Produit, String> reference;
    public static volatile SingularAttribute<Produit, String> nom;
    public static volatile SingularAttribute<Produit, Float> prixHt;

}