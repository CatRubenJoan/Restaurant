package controllers;

import beanEntity.Produit;
import beanEntity.Promotion;
import beanSession.EJBCuisinierLocal;
import beanSession.EJBProduitLocal;
import beanSession.EJBPromotionLocal;
import beanSession.EJBSousTypeLocal;
import beanSession.EJBStatutLocal;
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
        int idPromo1 = 0;
        int idPromo2 = 0;
        int idPromo3 = 0;
        int idPromo4 = 0;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletCreerObjet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletCreerObjet at " + request.getContextPath() + "</h1>");

//            out.println("Statut");
//            eJBStatut.creerStatut();
//            out.println("<br>" + eJBStatut.ajouterStatut("BOUH", "Bwwwwwwwwwwaaaaaaaaa"));
//            out.println("<br>Type");
//            eJBType.creerType();
//            out.println("<br>Sous Type");
//            eJBSousType.creerSousType();
//            out.println("<br>Cuisinier");
//            out.println("<br>" + eJBCuisinier.creerCuisinier("1000", "Bouh"));
//            out.println("<br>" + eJBCuisinier.creerCuisinier("1001", "Ratatouille"));
//            out.println("<br>Promotion");
//            idPromo1 = eJBPromotion.creerPromotion(10f, new GregorianCalendar(2014, 2, 10).getTime(), new GregorianCalendar(2014, 2, 20).getTime()).getId();
//            idPromo2 = eJBPromotion.creerPromotion(15f, new GregorianCalendar(2014, 6, 10).getTime(), new GregorianCalendar(2014, 7, 10).getTime()).getId();
//            idPromo3 = eJBPromotion.creerPromotion(05f, new GregorianCalendar(2014, 4, 10).getTime(), new GregorianCalendar(2014, 5, 10).getTime()).getId();
//            idPromo4 = eJBPromotion.creerPromotion(25f, new GregorianCalendar(2014, 3, 10).getTime(), new GregorianCalendar(2014, 4, 10).getTime()).getId();
//            out.println("<br>" + idPromo1);
//            out.println("<br>Produit");
//            p1 = eJBProduit.creerProduit("Pate", "Pate", "52", "vieux", true, 12.30f, "PAT").getReference();
//            p2 = eJBProduit.creerProduit("Steak", "Viande", "556", "carnivor", true, 15.30f, "VIA").getReference();
//            p3 = eJBProduit.creerProduit("Chilled monkey brain", "Cervelle de singe en sorbet", "400 cal", "Recette traditionnelle", true, 15.3f, "ENTFR").getReference();
//            p4 = eJBProduit.creerProduit("Snake surprise", "Serpent surprise", "150 cal", "Recette traditionnelle", true, 16.8f, "ENTCH").getReference();
//            
//            out.println("<br>" + p1);
//            out.println("<br>" + p2);
//            out.println("<br>Attribuer un cuisinier");
//            out.println("<br>" + eJBProduit.attribuerCuisinier(p2, "1000"));
//            out.println("<br>Attribuer une promotion");
//            out.println("<br>" + eJBProduit.attribuerPromotion(p1, idPromo1));
//            out.println("<br>Attribuer une promotion");
//            out.println("<br>" + eJBProduit.attribuerPromotion(p2, idPromo1));
//            out.println("<br>Attribuer une promotion");
//            out.println("<br>" + eJBProduit.attribuerPromotion(p3, idPromo1));
//            out.println("<br>Attribuer une promotion");
//            out.println("<br>" + eJBProduit.attribuerPromotion(p4, idPromo2));
            out.println("<br>Les promotions");
            for (Promotion p : eJBPromotion.lesPromotions(new Date())) {
                out.println("<br>" + p.getId() + " - " + p.getTauxPromotion());
                out.println("<br>Les produits");
                for (Produit prod : p.getLesProduits()) {
                    out.println("<br>" + prod.getNom() + " - " + prod.getReference());
                }
            }
            
            out.println("<br>BOUH !!!");
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
