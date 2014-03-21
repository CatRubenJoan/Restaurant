/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beanSession.EJBMoyenPaiementLocal;
import beanSession.EJBPaiementLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servTestJoan", urlPatterns = {"/servTestJoan"})
public class servTestJoan extends HttpServlet {

    @EJB
    private EJBMoyenPaiementLocal moyenPaiement;
    @EJB
    private EJBPaiementLocal testPaiement;
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testJoan</title>");
            out.println("</head>");
            out.println("<body>");

            Date d2 = new GregorianCalendar(2014, 5, 16).getTime();
            out.println(moyenPaiement.ajouterMoyenPaiement("TEST", "test"));
           
            moyenPaiement.creerMoyenPaiement();
            Date d1 = new GregorianCalendar(2014, 0, 10).getTime();
            testPaiement.creerPaiement("dupond", 50.3f, d1,"CB",1);
            testPaiement.creerPaiement("albert", 58.9f, d1,"UI",2);
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
