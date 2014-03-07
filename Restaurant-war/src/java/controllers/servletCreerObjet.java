package controllers;

import beanEntity.*;
import beanSession.CommandeEnCoursLocal;
import beanSession.EJBCuisinierLocal;
import beanSession.EJBProduitLocal;
import beanSession.EJBStatutLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletCreerObjet", urlPatterns = {"/servletCreerObjet"})
public class servletCreerObjet extends HttpServlet {
    @EJB
    private EJBStatutLocal eJBStatut;
    @EJB
    private EJBProduitLocal eJBProduit;
    @EJB
    private EJBCuisinierLocal eJBCuisinier;
    @EJB
    private CommandeEnCoursLocal commandeEnCours;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletCreerObjet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletCreerObjet at " + request.getContextPath() + "</h1>");
            
//            out.println(commandeEnCours.creerCommandeBidon(new Date(), 3));
            out.println( eJBCuisinier.creerCuisinier("1000", "Bouh"));
            out.println( eJBCuisinier.creerCuisinier("1001", "Ratatouille"));
            out.println( eJBProduit.creerProduit("3","Pate","Pate","52", "vieux", true, 12.30f));
            out.println( eJBProduit.creerProduit("4","Steak","Viande","556", "carnivor", true, 15.30f));
            eJBStatut.creerStatut();
            out.println( eJBStatut.ajouterStatut("BOUH", "Bwwwwwwwwwwaaaaaaaaa"));
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public servletCreerObjet() {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
