<%-- 
    Document   : jspDetailProduit
    Created on : 25 mars 2014, 07:10:20
    Author     : Bouhpoyo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Détail du produit : ${produit.nom}</h1>
        <h2>${produit.prixHt} €</h2>
        <h3>${produit.composition}</h3>
        <h4>${produit.qualiteNutritive}</h4>
        <h5>${produit.historique}</h5>
        <a href="">Commander</a>
    </body>
</html>
