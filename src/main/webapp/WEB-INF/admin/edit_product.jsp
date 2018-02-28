<%-- 
    Document   : edit_product
    Created on : Feb 28, 2018, 5:38:35 AM
    Author     : shalaby
--%>
<c:if test="${empty requestScope.imgURL}">
    <c:set var="imgURL" value="${requestScope.edit_product.imgURL}"/>
</c:if>
<c:if test="${!empty requestScope.imgURL}">
    <c:set var="imgURL" value="${requestScope.imgURL}"/>
</c:if>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
