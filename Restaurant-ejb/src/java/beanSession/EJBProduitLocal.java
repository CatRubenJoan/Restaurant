/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Produit;
import beanEntity.SousType;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author cdi412
 */
@Local
public interface EJBProduitLocal {
    public Produit creerProduit(String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, SousType sousType);
    public Produit creerProduit(String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, String sousTypeId);
    public boolean attribuerCuisinier(String prod, String cuisi);
    public boolean attribuerPromotion(String prod, int promo);
    public boolean attribuerPromotion(ArrayList<Produit> prod, int promo);
}
