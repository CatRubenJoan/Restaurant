package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TESTsousController implements controllerInterface{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String url = "/WEB-INF/jspTest2.jsp";
        //CODE
        return url; 
    }
 
    
}
