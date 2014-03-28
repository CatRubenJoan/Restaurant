package controllers;

import beanEntity.Produit;
import beanEntity.SousType;
import beanSession.EJBSousTypeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SsControllerListeProduit implements controllerInterface{
    EJBSousTypeLocal eJBSousType = lookupEJBSousTypeLocal();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspListeProduit.jsp";
        String idSousType = request.getParameter("st");

//        if(request.getParameter("comment")!=null){
//            request.setAttribute("comment", request.getParameter("comment"));
//        }
        
        if (idSousType != null) {
            SousType st = eJBSousType.unSousType(idSousType);
            request.setAttribute("listProduit", st.getLesProduits());
        }
        return url;
    }

    private EJBSousTypeLocal lookupEJBSousTypeLocal() {
        try {
            Context c = new InitialContext();
            return (EJBSousTypeLocal) c.lookup("java:global/Restaurant/Restaurant-ejb/EJBSousType!beanSession.EJBSousTypeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
