package beanSession;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EJBLogin implements EJBLoginLocal {
    @EJB
    private EJBCuisinierLocal eJBCuisinier;

    public int verifierLogin(String codeIHM) {//A FAIRE, vérifier existence table/employé dans la base
        int typeIHM = 3;

        int enInt = Integer.parseInt(codeIHM);
        
        //clients
        if (enInt >= 0 && enInt < 1000) {
            typeIHM = 0;            
        }
        
        //serveurs
        if (enInt >= 1000 && enInt < 2000) {
            typeIHM = 1;
        }

        //cuisiniers
        if (enInt >= 2000 && enInt < 3000) {
            typeIHM = 2;            
        }

        return typeIHM;
    }
}
