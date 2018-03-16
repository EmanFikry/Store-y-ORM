<%-- 
   Document   : addProduct
   Created on : Mar 3, 2018, 7:16:36 PM
   Author     : romysaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src=http://code.jquery.com/jquery-latest.min.js></script>
        <link rel="stylesheet" href="css/UpdateProductStyle.css">
        <title>Add Product Page</title>
    </head>
    <body>

        <form method=post ENCTYPE="MULTIPART/FORM-DATA" action="AddProduct" id="infoForm">
            <fieldset>
                <center><h1>Add Product:</h1></center>
                <div>
                    <label for="name">Product name:</label>
                    <input type="text" name="productName"  id="productName" maxlength="50"  placeholder="Enter Name" onblur="checkName()" required >
                    <label id="nameError"></label>
                    
                    <label for="price">Product price:</label>
                    <input type="number" id="productPrice" name="productPrice" maxlength="50" placeholder="Enter price" onblur="checkNumber()" required>
                    <label id="priceError"></label>
                    
                    <label for="category">Product category:</label>
                    <input type="text" id="productCategory" name="productCategory"  maxlength="50" placeholder="Enter category" onblur="checkName()" required>
                    <label id="categoryError"></label>
                    
                    <label for="amount">Product amount:</label>
                    <input type="number" id="productAmount" name="productAmount"  maxlength="50" placeholder="Enter amount" onblur="checkNumber()" required>
                    <label id="amountError"></label>
                    
                    <label for="imgurl">Product imgurl:</label>
                    <label for="profile_pic">Choose file to upload</label>
                    <input type="file" id="profile_pic" name="profile_pic" 
                           accept=".jpg, .jpeg, .png" ><br>

                    <label for="description">Product description:</label>
                    <input type="text" id="productDescription" name="productDescription" maxlength="100" placeholder="Enter description" onblur="checkName()" required>
                    <label id="descriptionError"></label>

                    <input type="submit" value="Submit" id="update">
                </div>
            </fieldset>
        </form>

    </body>
</html>
