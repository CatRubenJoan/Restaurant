<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil IHM Client</title>
    </head>
    <body>
        <h1>Hello Client!</h1>
        <p>Votre emplacement : Table n°${commande.table.numero}</p>
        <jsp:include page="jspType.jsp" flush="true"/>
        <!--<p><a href="controllerPrincipal?section=pageCommande">Commander</a></p>-->
        <p>Appel serveur</p>
    </body>
</html>
