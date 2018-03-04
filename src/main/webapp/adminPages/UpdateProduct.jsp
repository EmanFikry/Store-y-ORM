<%-- 
    Document   : UpdateProduct
    Created on : Mar 4, 2018, 4:18:53 AM
    Author     : Ghada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product Page</title>
    </head>
    <body>
        <form method=post action="EditProduct">
            <div>

                <input type="text" id="1" name="productName" value="Samsung" onblur="validateField()" maxlength="50" required>
                <input type="text" id="2" name="price" value="5000" onblur="validateField()" required>
                <input type="text" id="3" name="category" value="mobile" onblur="validateField()" required>
                <input type="text" id="4" name="amount" value="5" onblur="validateField()" required>
                <input type="text" id="5" name="imgURL" value="imgURL" onblur="validateField()" required>
                <input type="text" id="6" name="description" value="good mobile" onblur="validateField()" required>
                <label id="errorMsg"></label>
                <input type="button" value="update" id="update">
            </div>
        </form>
        <script>
            var req = null;
            function validateField()
            {
                if (window.XMLHttpRequest)
                    req = new XMLHttpRequest();
                else if
                        (window.ActiveXObject)
                    req = new ActiveXObject(Microsoft.XMLHTTP);

                req.onreadystatechange = printInvalidMsg;
                fieldVal = document.getElementById(this.id).value;
                fieldName = this.name;
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
