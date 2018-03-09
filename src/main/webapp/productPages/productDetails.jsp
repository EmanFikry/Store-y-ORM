<%-- 
    Document   : productDetails
    Created on : Mar 8, 2018, 9:16:37 PM
    Author     : Eman-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Product details</h1>
<!--        <img src="${productObject.imgURL}"/>-->

        <img src="https://www.w3schools.com/images/w3schools_green.jpg"/>
        <br>
        <label for="pName"><b>Name</b></label>
        <br>
        <input type="text" id="pName" name="pName" value="${productObject.name}" readonly/>
        <br>
        <label for="pPrice"><b>Price</b></label>
        <br>
        <input type="text" id="pPrice" name="pPrice" value="${productObject.price}" readonly/>
        <br>
        <label for="pCategory"><b>Category</b></label>
        <br>
        <input type="text" id="pCategory" name="pCategory" value="${productObject.category}" readonly/>
        <br>
        <label for="pAmount"><b>Total amount</b></label>
        <br>
        <input type="text" id="pAmount" name="pAmount" value="${productObject.amount}" readonly/>
        <br>
        <label for="pDescription"><b>Description</b></label>
        <br>
        <input type="text" id="pDescription" name="pDescription" value="${productObject.description}" readonly/>
        <br>
        <input type="button" value="Back" onclick="backToMainPage()">
        <script>
            function backToMainPage()
            {
//            <jsp:forward page="/generalPages/login.jsp"/>
            }
        </script>
        <c:remove var="productObject" scope="application" />
    </body>
</html>
