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
public interface EJBSousTypeLocal {
    public void creerSousType();
    public boolean ajouterSousType(String id, String lib, Type tp); 
    public boolean ajouterSousType(String id, String lib, String type);    
}
