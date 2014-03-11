/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Type;
import javax.ejb.Local;

/**
 *
 * @author cdi412
 */
@Local
public interface EJBTypeLocal {
    public void creerType();
    public boolean ajouterType(String id, String lib);
    /**
     * Modifier un type
     * @param id : id du type à modifier
     * @param lib : nouveau libellé modifié
     * @return 
     */
    public boolean modifierType(String id, String lib);
    public boolean supprimerType(String id);
//    public Type unType(String id);
}
