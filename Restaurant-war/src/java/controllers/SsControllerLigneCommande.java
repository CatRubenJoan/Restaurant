/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beanEntity.Commande;
import beanEntity.Produit;
import beanSession.EJBLigneCommandeLocal;
import beanSession.EJBProduitLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi412
 */
public class SsControllerLigneCommande implements controllerInterface {

    EJBLigneCommandeLocal eJBLigneCommande = lookupEJBLigneCommandeLocal();
    EJBProduitLocal eJBProduit = lookupEJBProduitLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspBienvenueClient.jsp";
        HttpSession session = request.getSession();
        Commande order = (Commande) session.getAttribute("commande");
        String refProd = request.getParameter("prod");
        String com = request.getParameter("commentaire");

        if (refProd != null) {
            Produit p = eJBProduit.unProduit(Integer.parseInt(refProd));
            order = eJBLigneCommande.ajoutLigneCommande(Integer.toString(order.getNumCommande()), 1, p.getPrixHt(), com, refProd);
            
            session.setAttribute("commande", order);
            url = "/controllerPrincipal?section=pageListeProduit&st="+p.getSousType().getId();
        }
        return url;
    }

    private EJBProduitLocal lookupEJBProduitLocal() {
        try {
            Context c = new InitialContext();
            return (EJBProduitLocal) c.lookup("java:global/Restaurant/Restaurant-ejb/EJBProduit!beanSession.EJBProduitLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EJBLigneCommandeLocal lookupEJBLigneCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (EJBLigneCommandeLocal) c.lookup("java:global/Restaurant/Restaurant-ejb/EJBLigneCommande!beanSession.EJBLigneCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
