package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SsControllerCommande implements controllerInterface{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspCommande.jsp";
        //récupérer parameter table (n°table)
        
        
        return url;
    }
    
}
