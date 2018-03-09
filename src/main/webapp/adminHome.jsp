<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/adminStyles.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
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

        <script type="text/javascript" src="js/adminJS.js"></script>
    </body>
</html>
