<%-- 
    Document   : jspSousType
    Created on : 20 mars 2014, 11:22:20
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
        <h1>Les sous types</h1>
    <c:forEach var="st" items="${sType}">
        <a href="">${st.infoSousType}</a><br>
    </c:forEach>
    </body>
</html>
