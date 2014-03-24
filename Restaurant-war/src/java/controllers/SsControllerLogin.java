package controllers;

import beanSession.EJBLoginLocal;
import beanSession.EJBTableLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SsControllerLogin implements controllerInterface {

    EJBLoginLocal eJBLogin = lookupEJBLoginLocal();
    EJBTableLocal eJBTable = lookupEJBTableLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspLogin.jsp";

        if ("E".equals(request.getParameter("type"))) {
            url = "/WEB-INF/jspLoginEmployes.jsp";
        } 
        if ("C".equals(request.getParameter("type"))) {
            url = "/WEB-INF/jspLoginTable.jsp";
        }

        if (request.getParameter("doIt") != null) {
            String n = request.getParameter("identifier");
            String p = request.getParameter("places");
            int typeIHM = eJBLogin.verifierLogin(n);

            if (typeIHM == 3) {
                url = "/WEB-INF/jspLoginFailed.jsp";
                request.setAttribute("erreurlogin", n);
            } else {
                //clients
                if (typeIHM == 0 && "C".equals(request.getParameter("type"))) {
                    url = "/WEB-INF/jspBienvenueClient.jsp";
                    request.setAttribute("notable", n);
                    request.setAttribute("nbconvives", p);
                }
                //serveurs
                if (typeIHM == 1) {
                    url = "/WEB-INF/jspBienvenueServeur.jsp";
                }
                //cuisiniers
                if (typeIHM == 2) {
                    url = "/WEB-INF/jspBienvenueCuisinier.jsp";
                }
            }
        }
        return url;
    }

    private EJBTableLocal lookupEJBTableLocal() {
        try {
            Context c = new InitialContext();
            return (EJBTableLocal) c.lookup("java:global/Restaurant/Restaurant-ejb/EJBTable!beanSession.EJBTableLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EJBLoginLocal lookupEJBLoginLocal() {
        try {
            Context c = new InitialContext();
            return (EJBLoginLocal) c.lookup("java:global/Restaurant/Restaurant-ejb/EJBLogin!beanSession.EJBLoginLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
