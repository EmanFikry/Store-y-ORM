<%-- 
    Document   : UpdateProduct
    Created on : Mar 3, 2018, 4:18:53 AM
    Author     : Ghada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src=http://code.jquery.com/jquery-latest.min.js></script>
        <link rel="stylesheet" href="css/UpdateProductStyle.css">
        <title>Update Product Page</title>
    </head>
    <body>
        <form method=post action="EditProduct" id="infoForm">
            <fieldset>
                <center><legend>Product info</legend></center>
                <div>
                    <label for="name">Name:</label>
                    <input type="hidden" name="id" value="${id}">
                    <input type="text" id="1" name="productName" value="${name}"           onblur="validateField(this)" maxlength="50" required>
                    <label for="price">price:</label>
                    <input type="text" id="2" name="price"       value="${price}"          onblur="validateField(this)"  required>
                    <label for="category">category:</label>
                    <input type="text" id="3" name="category"    value="${category}"       onblur="validateField(this)" maxlength="50" required>
                    <label for="amount">amount:</label>
                    <input type="text" id="4" name="amount"      value="${amount}"         onblur="validateField(this)"  required>
                    <label for="imgURL">imgURL:</label>
                    <input type="text" id="5" name="imgURL"      value="${imgURL}"         onblur="validateField(this)" maxlength="100" required>
                    <label for="description">description:</label>
                    <input type="text" id="6" name="description" value="${description}"    onblur="validateField(this)" maxlength="200" required>
                    <label id="errorMsg"></label>
                    <input type="submit" value="update" id="update">
                </div>
            </fieldset>
        </form>
        <script>
            var req = null;
            function validateField(ev)
            {
                if (window.XMLHttpRequest)
                    req = new XMLHttpRequest();
                else if
                        (window.ActiveXObject)
                    req = new ActiveXObject(Microsoft.XMLHTTP);

                req.onreadystatechange = printInvalidMsg;
                fieldVal = document.getElementById(ev.id).value;
                fieldName = ev.name;
                url = "EditProduct" + "?name=" + fieldName + "&value=" + fieldVal + "&timeStamp=" + new Date().getTime();
                req.open("GET", url, true);
                req.send(null);
            }
            function printInvalidMsg() {
                if (req.readyState == 4 && req.status == 200) {
                    xmlvalue = req.responseText;
                    document.getElementById("errorMsg").value = xmlvalue;
                }
            }
        </script>
    </body>
</html>
