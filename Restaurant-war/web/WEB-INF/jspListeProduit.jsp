<%-- 
    Document   : jspListeProduit
    Created on : 21 mars 2014, 09:43:42
    Author     : cdi412
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Les Produits</h1>
        <c:forEach var="p" items="${listProduit}">
            ${p.nom}
            <form method="POST" action="controllerPrincipal?section=pageDetailProduit&produit=${p.reference}">
            Commentaire (à point, sans sel, sans poils pubiens) : <input type="text" name="comment" size="50">
            <INPUT type="submit" name="doIt" value="OK"/>
            
            </form>
        </c:forEach>

    </body>
</html>
