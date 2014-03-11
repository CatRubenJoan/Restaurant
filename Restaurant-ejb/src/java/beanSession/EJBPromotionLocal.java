/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanSession;

import beanEntity.Promotion;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author cdi412
 */
@Local
public interface EJBPromotionLocal {
    public Promotion creerPromotion(float taux, Date dateDebut, Date dateFin);
}
