<%-- 
    Document   : deleteProduct
    Created on : Mar 2, 2018, 10:57:50 AM
    Author     : Eman-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <br>
        <div>
            <center>
                <form method=post action="LoginServlet">
                    <div>
                        <div>
                            <input type="text" id="1" name="1"
                                   value="phone" required>
                            <button type="button" id="d1">delete</button>
                        </div>
                        <div>
                            <input type="text" id="2" name="2"
                                   value="home" required>
                            <button type="button" id="d2">delete</button>
                        </div>
                        <div>
                            <input type="text" id="3" name="3"
                                   value="mobile" required>
                            <button type="button" id="d3">delete</button>
                        </div>
                    </div>
                </form>
            </center>
        </div>
        <script>
            $("button").click(function () {
                alert(this.id);
                var isDeleteButton = this.id.startsWith("d");
                if (isDeleteButton) {
                    var clickedButton = document.getElementById(this.id);
                    var choosedProductID = this.id.substring(1);
                    alert(document.getElementById(choosedProductID).value);
                    var choosedProductValue = document.getElementById(choosedProductID).value;
                    clickedButton.parentNode.parentNode.removeChild(clickedButton.parentNode);

                    if (window.XMLHttpRequest)
                    {
                        req = new XMLHttpRequest();
                    } else if (window.ActiveXObject)
                    {
                        req = new ActiveXObject(Microsoft.XMLHTTP);
                    }
                    req.onreadystatechange = handleProductDeletion;
                    url = "RemoveProduct?choosedProductID=" + choosedProductID;
                    req.open("Post", url, true);
                    req.send();
                }

            });

            function handleProductDeletion()
            {
                if (req.readyState == 4)
                {
                    if (req.status == 200)
                    {
                        //document.getElementById("displayResult").innerHTML = req.responseText;
                    } else
                    {
                    }
                }
            }
        </script>
    </body>
</html>
