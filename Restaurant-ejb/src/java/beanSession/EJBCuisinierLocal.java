/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Cuisinier;
import javax.ejb.Local;

/**
 *
 * @author cdi412
 */
@Local
public interface EJBCuisinierLocal {
    public boolean creerCuisinier(String codeIHM, String nom);
    public Cuisinier unCuisinier(String code);
}
