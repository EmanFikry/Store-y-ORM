<%-- 
    Document   : signin
    Created on : Feb 23, 2018, 11:29:55 AM
    Author     : Eman-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <br>
        <div>
            <center>
                <form method=post action="LoginServlet">
                    <div>
                        <h1>Sign In</h1>
                        <br>
                        <label for="loginemail"><b>Email</b></label>
                        <br>
                        <input type="text" placeholder="Enter Email" id="loginemail" name="loginemail"
                               required>
                        <label>${invalidEmail}</label>
                        <br>
                        <br>
                        <label for="loginpas"><b>Password</b></label>
                        <br>
                        <input type="password" placeholder="Enter Password" id="loginpas" name="loginpas"
                               required>
                        <label>${invalidPassword}</label>
                        <br>
                        <div>
                            <button type="submit">Sign In</button>
                        </div>
                    </div>
                </form>
            </center>
        </div>
        <c:remove var="invalidEmail" scope="application" />
        <c:remove var="invalidPassword" scope="application" />

    </body>
</html>
