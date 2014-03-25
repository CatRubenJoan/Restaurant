<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ma commande</title>
    </head>
    <body>
        <h1>${nocommande}</h1>

        <c:set var="nocommande" value="${nocommande}" scope="request"/>
    </body>
</html>
