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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>


        <table id="example">
            <tr> 
                <th>Customer Name</th>
                <th>Customer Email</th>
            </tr>
        </table>

        <script>
            updateProducts();
            function  updateProducts()
            {
                console.log("hereeeeeeeeeeeee 123344");
                $.ajax({
                    url: "DisplayUsers",
                    type: 'GET',
                    dataType: 'json',
                    contentType: 'application/json',
                    error: function (xhr, status, error) {
                        console.log(xhr);
                        console.log(status);
                        console.log(error);
                    },
                    success: function (data)
                    {
                        console.log("he");
                        for (i = 0; i < data.length; i++) {
                            $("#example").append('<tr><td>' + data[i].name + '</td><td>' + data[i].email + '</td></tr>');

                        }
                    }
                });
            }

        </script>



    </body>
</html>
