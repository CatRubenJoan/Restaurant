/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Produit;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author blt
 */
@Local
public interface EJBCarteLocal {

    public Collection<Produit> listeProduitsParCat(String idSousType);
    
}
