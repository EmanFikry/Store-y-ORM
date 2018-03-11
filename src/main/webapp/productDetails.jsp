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
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <title>JSP Page</title>
        <style>
            input{
                width:60%;
                height:5%;
                margin-left:10px;
            }
        </style>
    </head>
    <body style="text-align: center; font-family: 'Raleway', sans-serif;">

        <h1>Product details</h1>
<!--        <img src="${productObject.imgURL}"/>-->

        <table>
            <br>
            <label for="pName"><b>Name</b></label>
            &nbsp
            <input type="text" id="pName" name="pName" value="" readonly/>
            <br>
            <br>
            <label for="pPrice"><b>Price</b></label>
            &nbsp
            <input type="text" id="pPrice" name="pPrice" value="" readonly/>
            <br>
            <br>
            <label for="pCategory"><b>Category</b></label>
            &nbsp
            <input type="text" id="pCategory" name="pCategory" value="" readonly/>
            <br>
            <br>
            <label for="pAmount"><b>Total amount</b></label>
            &nbsp
            <input type="text" id="pAmount" name="pAmount" value="" readonly/>
            <br>
            <br>
            <label for="pDescription"><b>Description</b></label>
            &nbsp
            <input type="text" id="pDescription" name="pDescription" value="" readonly/>
            <br>
            <br>
            <input style="width:40%; height:48px;border-width:0;background-color:#ba3e9d; color:#fff;" type="button" value="Back" onclick="backToMainPage()">
        </table>       
        <script>
            function backToMainPage()
            {
            }
        </script>
        <c:remove var="productObject" scope="application" />
    </body>
</html>
