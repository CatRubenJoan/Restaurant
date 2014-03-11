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
public interface EJBTypeLocal {
    public void creerType();
    public boolean ajouterType(String id, String lib);
}
