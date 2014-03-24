<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Failed</title>
    </head>
    <body>
        ${erreurlogin} n'est pas un identifiant valide
        <a href="controllerPrincipal?section=pageLogin">Saisir un identifiant valide</a><br>
    </body>
</html>
