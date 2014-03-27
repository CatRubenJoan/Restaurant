<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ma commande</title>
    </head>
    <body>
        <h1>Commande n° ${commande.numCommande}</h1>
        <h2>${commande.dateHeure}</h2>
        <h3>Convives ${commande.nbPersonne}</h3>
        <h4>Table n° ${commande.table}</h3>
    </body>
</html>
