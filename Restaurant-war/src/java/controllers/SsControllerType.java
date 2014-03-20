package controllers;

import beanEntity.Type;
import beanSession.EJBTypeLocal;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SsControllerType implements controllerInterface{
    EJBTypeLocal eJBType = lookupEJBTypeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspTestType.jsp";
        
        Collection<Type> lesType = eJBType.lesTypes();
        request.setAttribute("type", lesType);
        
        return url; 
    }

    private EJBTypeLocal lookupEJBTypeLocal() {
        try {
            Context c = new InitialContext();
            return (EJBTypeLocal) c.lookup("java:global/Restaurant/Restaurant-ejb/EJBType!beanSession.EJBTypeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
 
    
}