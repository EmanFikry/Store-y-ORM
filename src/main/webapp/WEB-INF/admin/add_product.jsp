<%-- 
    Document   : add_product
    Created on : Feb 28, 2018, 5:37:46 AM
    Author     : shalaby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty requestScope.imgURL}">
    <c:set var="imgURL" value="${pageContext.request.contextPath}/default_image.jpg"/>
</c:if>
<c:if test="${!empty requestScope.imgURL}">
    <c:set var="imgURL" value="${requestScope.imgURL}"/>
</c:if>
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
