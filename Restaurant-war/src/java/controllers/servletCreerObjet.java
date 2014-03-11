package controllers;

import beanEntity.Produit;
import beanEntity.SousType;
import beanSession.CommandeEnCoursLocal;
import beanSession.EJBCuisinierLocal;
import beanSession.EJBProduitLocal;
import beanSession.EJBPromotionLocal;
import beanSession.EJBSousTypeLocal;
import beanSession.EJBStatutLocal;
import beanSession.EJBTypeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletCreerObjet", urlPatterns = {"/servletCreerObjet"})
public class servletCreerObjet extends HttpServlet {

    @EJB
    private EJBPromotionLocal eJBPromotion;
    @EJB
    private EJBSousTypeLocal eJBSousType;
    @EJB
    private EJBTypeLocal eJBType;
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
        int idPromo = 0;
        int p1 = 0;
        int p2 = 0;
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
            out.println("Statut");
            eJBStatut.creerStatut();
            out.println("<br>" + eJBStatut.ajouterStatut("BOUH", "Bwwwwwwwwwwaaaaaaaaa"));
            out.println("<br>Type");
            eJBType.creerType();
            out.println("<br>Sous Type");
            eJBSousType.creerSousType();
            out.println("<br>Cuisinier");
            out.println("<br>" + eJBCuisinier.creerCuisinier("1000", "Bouh"));
            out.println("<br>" + eJBCuisinier.creerCuisinier("1001", "Ratatouille"));
            out.println("<br>Promotion");
            idPromo = eJBPromotion.creerPromotion(10f, new Date(), new Date()).getId();
            out.println("<br>" + idPromo);
            out.println("<br>Produit");
            p1 = eJBProduit.creerProduit("Pate", "Pate", "52", "vieux", true, 12.30f, "PAT").getReference();
            p2 = eJBProduit.creerProduit("Steak", "Viande", "556", "carnivor", true, 15.30f, "VIA").getReference();
            out.println("<br>" + p1);
            out.println("<br>" + p2);
            out.println("<br>Attribuer un cuisinier");
            out.println("<br>" + eJBProduit.attribuerCuisinier(p2, "1000"));
            out.println("<br>Attribuer une promotion");
            out.println("<br>" + eJBProduit.attribuerPromotion(p1, idPromo));
            out.println("<br>" + eJBProduit.attribuerPromotion(p2, idPromo));
            for (Produit p : eJBPromotion.unePromotion(idPromo).getLesProduits()) {
                out.println("<br>" + p.getNom());
            }
            out.println("<br>Ajouter Sous Type");
            eJBSousType.ajouterSousType("BEU", "BEURK", "BOI");
//            for (SousType s : eJBType.) {
//                out.println("<br>" + p.getNom());
//            }


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
