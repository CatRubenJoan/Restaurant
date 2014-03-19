package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface controllerInterface {
        String execute(HttpServletRequest request, HttpServletResponse response);
}
