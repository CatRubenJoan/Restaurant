<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ma commande</title>
    </head>
    <body>
        <h1>Commande n° ${commande.numCommande} Table n° ${commande.table.numero}</h1>
        <h2>${commande.dateHeure}</h2>
            <c:forEach var="lc" items="${commande.lignesCommande}">
                ${lc.produit.nom} / ${lc.commentaire}<br>
            </c:forEach>
</body>
</html>
