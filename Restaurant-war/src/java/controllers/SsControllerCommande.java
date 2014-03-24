package controllers;

import beanEntity.Commande;
import beanSession.EJBCommandeLocal;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.emptyType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SsControllerCommande implements controllerInterface {

    EJBCommandeLocal eJBCommande = lookupEJBCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspCommande.jsp";

        //1ere visite: ouverture d'une commande
        if (request.getParameter("convives") != null && request.getParameter("table") != null) {
            int nbPersonnes = Integer.parseInt(request.getParameter("convives"));
            String noTable = request.getParameter("table");
            Commande order = eJBCommande.creationCommande(nbPersonnes, noTable);
            request.setAttribute("nocommande", order);
        }else{
//            String noComString = (String) request.getAttribute("nocommande");
//            int noComInt = Integer.parseInt(noComString);
        }

        return url;
    }

    private EJBCommandeLocal lookupEJBCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (EJBCommandeLocal) c.lookup("java:global/Restaurant/Restaurant-ejb/EJBCommande!beanSession.EJBCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
