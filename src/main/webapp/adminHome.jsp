<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/adminStyles.css">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link rel="stylesheet" href="css/UpdateProductStyle.css">

    </head>
    <body onload="load_it()">
        <div class="admin">
            Admin
        </div>
        <nav class="nav-bar">
            <a href="#" class="link_un" id="users_link">Users</a>
            <a href="#" class="link_un" id="products_link">Products</a>
            <a href="#" class="link_un" id="add_products_link">Add Product</a>
        </nav>
        <dialog open id="disDialog" class="dilg"></dialog>
        <dialog open id="userDialog" class="dilg"></dialog>
        <!--users div-->
        <div >
            <table id="customers" class="customersX">
                <tr>
                    <th >Name</th>
                    <th >Email</th>
                    <th >Address</th>
                    <th >View More</th>
                </tr>

            </table>
        </div>

        <!--products div-->
        <div class="">
            <table id="Products" class="ProductsX" style="display:none;">
                <tr>
                    <th >Name</th>
                    <th >Price</th>
                    <th >Amount</th>
                    <th >Update</th>
                    <th>Delete</th>
                    <th>View More</th>
                </tr>

            </table>


        </div>
        <div id='addProductDiv'></div>


        <script type="text/javascript" src="js/adminJS.js"></script>

    </body>
</html>
