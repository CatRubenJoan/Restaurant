/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beanEntity.Produit;
import beanSession.EJBProduitLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bouhpoyo
 */
public class SsControllerDetailProduit implements controllerInterface {
    EJBProduitLocal eJBProduit = lookupEJBProduitLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspDetailProduit.jsp";
        String idProduit = request.getParameter("produit");
        
        if (idProduit != null) {
            Produit p = eJBProduit.unProduit(Integer.parseInt(idProduit));
            request.setAttribute("produit", p);
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
}
