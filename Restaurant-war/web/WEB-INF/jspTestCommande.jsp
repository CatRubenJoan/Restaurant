<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspTestCommande
    Created on : 27 mars 2014, 16:53:08
    Author     : cdi412
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:forEach var="lc" items="${commande.lignesCommande}">
        ${lc.produit.nom}
    </c:forEach>
    </body>
</html>
