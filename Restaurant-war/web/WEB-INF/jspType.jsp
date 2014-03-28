<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspTestEntree
    Created on : 19 mars 2014, 16:30:05
    Author     : cdi412
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:forEach var="t" items="${type}">
    <a href="controllerPrincipal?section=pageSousType&t=${t.id}">${t.infoType}</a><br>
</c:forEach>
