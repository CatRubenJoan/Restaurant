package controllers;

import beanSession.CommandeEnCoursLocal;
import beanSession.EJBProduitLocal;
import beanSession.EJBSousTypeLocal;
import beanSession.EJBTypeLocal;
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

@WebServlet(name = "servTestRU", urlPatterns = {"/servTestRU"})
public class servTestRU extends HttpServlet {
    @EJB
    private EJBSousTypeLocal eJBSousType;
    @EJB
    private EJBTypeLocal eJBType;

    @EJB
    private EJBProduitLocal eJBProduit;
    @EJB
    private CommandeEnCoursLocal commandeEnCours;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servTestRU</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servTestRU at " + request.getContextPath() + "</h1>");

            out.println("<p>");
            out.println(commandeEnCours.creerServeur("1000", "Chuck Norris"));
            out.println(commandeEnCours.creerServeur("1001", "Ludwig van Beethoven"));
            out.println("<strong>creer serveurs DONE</strong>");
            out.println("</p>");

            out.println("<p>");
            out.println(commandeEnCours.creerTableWServeur(2, "0001", "1001"));
            out.println(commandeEnCours.creerTableWServeur(4, "0002", "1000"));
            out.println(commandeEnCours.creerTableWServeur(8, "0003", "1000"));
            out.println("<strong>creer tables DONE</strong>");
            out.println("</p>");

            out.println("<p>");
            //public boolean creerCommandeBidonWTable(Date dateHeure, int nbPersonne, int noTable)
            out.println(commandeEnCours.creerCommandeBidonWTable(new GregorianCalendar(2012, 11, 10, 11, 57, 05).getTime(), 2, 1));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 2, 1));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 1, 1));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 3, 2));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 4, 2));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 2, 2));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 3, 2));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 6, 3));
            out.println(commandeEnCours.creerCommandeBidonWTable(new Date(), 7, 3));
            out.println("<strong>creer commandes DONE</strong>");
            out.println("</p>");

            out.println("<p>");
            eJBType.creerType();
            eJBSousType.creerSousType();
            out.println("<strong>creer sous-type DONE</strong>");
            out.println("</p>");
            
            out.println("<p>");
            out.println(eJBProduit.creerProduit("Chilled monkey brains", "Cervelle de singe en sorbet", "400 cal", "Recette traditionnelle", true, 15.3f, "ENTFR"));
            out.println(eJBProduit.creerProduit("Snake surprise", "Serpent surprise", "150 cal", "Recette traditionnelle", true, 16.8f, "ENTCH"));
            out.println("<strong>creer produits DONE</strong>");
            out.println("</p>");


            out.println("<p>");
            //public float reglementCommande(int noCommandeARegler, int montant)
            out.println(commandeEnCours.reglementCommande(1, 17));
            out.println("<strong>creer paiements DONE</strong>");
            out.println("</p>");

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