/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import javax.ejb.Local;

/**
 *
 * @author cdi412
 */
@Local
public interface EJBSousTypeLocal {
    public void creerSousType();
    public boolean ajouterSousType(String id, String lib, String type);
    /**
     * Modifier le libellé du sous type
     * @param id : id du sous type à modifier
     * @param lib : nouveau libellé modifié
     * @return 
     */
    public boolean modifierSousType(String id, String lib);
    public boolean modifierSousType(String id, String lib, String type);
    public boolean supprimerSousType(String id);
}
