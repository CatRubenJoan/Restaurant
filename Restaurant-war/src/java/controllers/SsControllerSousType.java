/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beanEntity.SousType;
import beanEntity.Type;
import beanSession.EJBTypeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi412
 */
public class SsControllerSousType implements controllerInterface {

    EJBTypeLocal eJBType = lookupEJBTypeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspSousType.jsp";
        String idType = request.getParameter("t");

        if (idType != null) {
            Type t = eJBType.unType(idType);
            request.setAttribute("sType", t.getLesSousType());
        }
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
