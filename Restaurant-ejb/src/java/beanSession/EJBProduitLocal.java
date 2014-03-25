/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Produit;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author cdi412
 */
@Local
public interface EJBProduitLocal {
    public Produit creerProduit(String nom, String composition, String qualiteNutritive, String historique, boolean disponibilite, float prixHt, String sousTypeId);
    public boolean attribuerCuisinier(int prod, String cuisi);
    public boolean retirerCuisinier(int prod, String cuisi);
    public boolean attribuerPromotion(int prod, int promo);
    public boolean attribuerPromotion(ArrayList<Produit> prod, int promo);
    public boolean retirerPromotion(int prod, int promo);
    public boolean retirerPromotion(ArrayList<Produit> prod, int promo);
    public boolean retirerPromotion(int promo);
    public boolean modifierStatutProduit(int idProduit);
    public Produit unProduit(int ref);
}
