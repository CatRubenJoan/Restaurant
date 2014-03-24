package beanSession;

import javax.ejb.Local;

@Local
public interface EJBLoginLocal {

    public int verifierLogin(String codeIHM);
    
}
