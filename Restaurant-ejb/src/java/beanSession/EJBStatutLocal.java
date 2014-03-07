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
public interface EJBStatutLocal {
    public void creerStatut();
    public boolean ajouterStatut(String id, String lib);
}
