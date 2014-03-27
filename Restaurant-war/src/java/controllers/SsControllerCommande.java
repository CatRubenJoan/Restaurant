package controllers;

import beanEntity.Commande;
import beanSession.EJBCommandeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SsControllerCommande implements controllerInterface {

    EJBCommandeLocal eJBCommande = lookupEJBCommandeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspCommande.jsp";

        HttpSession session = request.getSession();
        Commande order = (Commande) session.getAttribute("commande");
        
        //cas accès aux commandes sans login
        if (order == null) {
            url = "/WEB-INF/jspLogin.jsp";
        //cas client loggé
        }else{
//            request.setAttribute("nocom", order.getNumCommande());
//            request.setAttribute("notab", order.getTable().getNumero());
//            request.setAttribute("nbper", order.getNbPersonne());
        }


//          if (request.getParameter("convives") != null && request.getParameter("table") != null) {
//        if (session.getAttribute("nbconvives") != null && session.getAttribute("notable") != null) {
//            session.setAttribute("intecommande", "Veuillez vous identifier");            
//            String s = (String) session.getAttribute("nbconvives");
//            int nbPersonnes = Integer.parseInt(s);
//            String noTable = (String) session.getAttribute("notable");
//            Commande order = eJBCommande.creationCommande(nbPersonnes, noTable);
//            session.setAttribute("commande", order);
//            request.setAttribute("nocommande", order.getNumCommande());

//            url = "/controllerPrincipal?section=pageType";
//        } else {
//            Commande order = (Commande) session.getAttribute("commande");
//            session.setAttribute("nocommande", order);
//
//            if (!order.getLignesCommande().isEmpty()) {
//                request.setAttribute("lignescommande", order.getLignesCommande());
//            }

//            if(session.getAttribute("objcommande")!=null){
//                Commande enCours = (Commande) session.getAttribute("objcommande");
//                request.setAttribute("nocommande", enCours.getNumCommande());
//                session.setAttribute("objcommande", enCours);                
//            }
//            String noComString = (String) request.getAttribute("nocommande");
//            String noComString = request.getParameter("nocommande");
//            int noComInt = Integer.parseInt(noComString);
//            Commande enCours = eJBCommande.uneCommande(noComInt);
//            request.setAttribute("objcommande", enCours);
//        }
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
