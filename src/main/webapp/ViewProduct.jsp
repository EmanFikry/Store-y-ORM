<%-- 
    Document   : ViewProduct
    Created on : Mar 4, 2018, 8:39:03 AM
    Author     : Ghada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src=http://code.jquery.com/jquery-latest.min.js></script>
        <title>JSP Page</title>
        <style>
            .dilg {
                display: block; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                padding-top: 3px; /* Location of the box */
                left: 20;
                top: 20;
                width: 80%; /* Full width */
                height: 80%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            }

        </style>
    </head>
    <body>
        <table style="width:100%">
            <caption>PRODUCTS</caption>
            <tr>
                <th>Name</th>
                <th>Price</th> 
                <th>category</th>
                <th>amount</th>
                <th>imgURL</th> 
                <th>description</th>
            </tr>
            <c:forEach items="${sessionScope.products}" var="pro">
                <tr>
                    <td id="name${pro.recID}" style="text-align: center; border: 1px solid black;">${pro.name}</td>
                    <td id="price${pro.recID}" style="text-align: center; border: 1px solid black;">${pro.price}</td>
                    <td id="category${pro.recID}" style="text-align: center; border: 1px solid black;">${pro.category}</td>
                    <td id="amount${pro.recID}" style="text-align: center; border: 1px solid black;">${pro.amount}</td>
                    <td id="imgURL${pro.recID}" style="text-align: center; border: 1px solid black;">${pro.imgURL}</td> 
                    <td id="description${pro.recID}" style="text-align: center; border: 1px solid black;">${pro.description}</td>

                    <td style="text-align: center; border: 1px solid black;">
                        <input id="${pro.recID}U" type="button" value="UPDATE" onclick="Update(${pro.recID})"/>
                    </td>
                    <td style="text-align: center; border: 1px solid black;">
                        <input id="${pro.recID}D" type="button" value="DELETE" onclick="Delete(${pro.recID})"/>
                    </td>
                    <td style="text-align: center; border: 1px solid black;">
                        <input id="${pro.recID}D" type="button" value="MORE" onclick="ShowMore(${pro.recID})"/>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <dialog open id="disDialog" class="dilg">
            <form>
                <h1>Information</h1>
                <fieldset>
                    <c:forEach items="${sessionScope.products}" var="pro">
                        <c:if test="${pro.recID == param.id}">
                            <label for="name">Name:</label>
                            <input type="text" id="name" value="${pro.name}" disabled="true"/>

                            <label for="price">Price:</label>
                            <input type="price" id="price" value="${pro.price}" disabled="true"/>
                        </c:if>
                    </c:forEach>
                </fieldset>

                <button type="button" onclick="closePopup()">OK</button>
            </form>
        </dialog>

        <script>
            var req = null;
            function Update(id)
            {
                if (window.XMLHttpRequest)
                    req = new XMLHttpRequest();
                else if
                        (window.ActiveXObject)
                    req = new ActiveXObject(Microsoft.XMLHTTP);

                req.onreadystatechange = openUpdateScreen;

                name = document.getElementById("name" + id).innerHTML;
                price = document.getElementById("price" + id).innerHTML;
                category = document.getElementById("category" + id).innerHTML;
                amount = document.getElementById("amount" + id).innerHTML;
                imgURL = document.getElementById("imgURL" + id).innerHTML;
                description = document.getElementById("description" + id).innerHTML;

                url = "ViewProduct";
                req.open("POST", url, true);
                req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                req.send("id=" + id
                        + "&name=" + name
                        + "&price=" + price
                        + "&category=" + category
                        + "&amount=" + amount
                        + "&imgURL=" + imgURL
                        + "&description=" + description
                        );
            }
            function openUpdateScreen() {
                if (req.readyState == 4 && req.status == 200) {
                    xmlvalue = req.responseText;
                    window.location.href = "updateProduct.jsp"
                }
            }


            function Delete(id)
            {
                if (window.XMLHttpRequest)
                    req = new XMLHttpRequest();
                else if
                        (window.ActiveXObject)
                    req = new ActiveXObject(Microsoft.XMLHTTP);

                req.onreadystatechange = refrehPage;

                url = "RemoveProduct";
                req.open("POST", url, true);
                req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                req.send("id=" + id);
            }

            function refrehPage() {
                if (req.readyState == 4 && req.status == 200) {
                    xmlvalue = req.responseText;
                    location.reload();
                }
            }

            function ShowMore(id) {
                window.location.href = "viewProduct.jsp?id=" + id;
            }

            function closePopup() {
                document.getElementById('disDialog').style.display = "none";
            }


        </script>
    </body>
</html>
