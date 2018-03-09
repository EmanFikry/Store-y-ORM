<%-- 
    Document   : ViewProduct
    Created on : Mar 4, 2018, 8:39:03 AM
    Author     : Ghada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet href="resource/css1.css" type="text/css">
        <script src=http://code.jquery.com/jquery-latest.min.js></script>
        <title>View Product Page</title>
    </head>
    <body>
        <script>
            function sendFn() {
                var name = $("#name").val();
                var msg = $("#msg").val();
                var jsonData = {"name": name, "message": msg};
                console.log(jsonData);
                $.ajax({url: 'ChatServlet',
                    type: 'GET',
                    contentType: 'application/json',
                    data: jsonData,
                    dataType: 'json',
                    success: function (data) {
                    }
                });
            }

            function render() {
                $.ajax({url: 'ChatServlet',
                    type: 'post',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        messages = data;
                        $("#myTable tr").remove();
                        for (i = 0; i < messages.length; i++) {
                            $("#myTable").append('<tr><td>' + messages[i].name + '</td><td>' + messages[i].msg + '</td></tr>');

                        }
                    }
                });
                $.ajax({url: 'FriendsServlet',
                    type: 'post',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data) {
                        friend = data;
                        $("#friendList tr").remove();
                        for (i = 0; i < friend.length; i++) {
                            $("#friendList").append('<tr><td>' + friend[i].userName + '</td><td>' + friend[i].myStatus + '</td></tr>');

                        }
                    }
                });
            }
        </script>
        <h1>Hello World!</h1>
    </body>
</html>
