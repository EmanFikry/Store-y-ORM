<%-- 
    Document   : customerProfile
    Created on : Mar 8, 2018, 4:21:07 PM
    Author     : Eman-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Profile</title>
    </head>
    <body>
        <div class="span12">

            <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                <thead>
                    <tr> 
                        <th>Customer Name</th>
                        <th>Customer Email</th>
                        <th>Customer Address</th>
                        <th>Customer Password</th>
                        <th>Customer Birthdate</th>
                        <th>Customer Job</th>
                        <th>Customer Creditlimit</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:if test="${!empty requestScope.users}">
                        <c:set var="usersList" value="${requestScope.users}" scope="request"/>
                    </c:if>
                    <c:if test="${!empty requestScope.usersList}">
                        <c:forEach items="${requestScope.usersList}" var="user">
                            <tr class="odd gradeX">
                                <td>${user.name}</td>
                                <td>${user.email}</td>
                                <td class="center">${user.address}</td>
                                <td>${user.password}</td>
                                <td>${user.birthdate}</td>
                                <td>${user.job}</td>
                                <td>${user.creditLimit}</td>
                              
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
    </body>
</html>
