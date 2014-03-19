package controllers;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controllerPrincipal extends HttpServlet {

    HashMap<String, controllerInterface> map;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "/WEB-INF/jspTest.jsp";

        if (request.getParameter("section") != null) {
            String n = request.getParameter("section");
            if (map.containsKey(n)) {
                controllerInterface c = map.get(n);
                url = c.execute(request, response);
            }
        }
        request.getRequestDispatcher(url).include(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
//                if (map == null) {
        System.out.println(">>>>>>>>init map");
        map = new HashMap<>();

        for (Enumeration e = this.getServletConfig().getInitParameterNames();
                e.hasMoreElements();) {
            String n = (String) e.nextElement();
//                if (n.equals(request.getParameter("section"))) {
            String v = this.getServletConfig().getInitParameter(n);
            try {
                controllerInterface c = (controllerInterface) Class.forName(v).newInstance();
                map.put(n, c);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(controllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("iController ClassNotFound :" + ex.getMessage());
            } catch (InstantiationException ex) {
                Logger.getLogger(controllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("iController InstantiationException :" + ex.getMessage());
            } catch (IllegalAccessException ex) {
                Logger.getLogger(controllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("iController IllegalAccessException :" + ex.getMessage());
            }
//                }
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
