<%-- 
   Document   : addProduct
   Created on : Mar 3, 2018, 7:16:36 PM
   Author     : romysaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
        var validName = false;
        var validNumber = false;
        var validUrl = false;

        function submitForm()
        {
            if (validName && validUrl && validNumber)
            {
                return true;
            } else
            {
                return false;
            }
        }
        function checkName()
        {
            var nameRegex = /^[a-zA-Z]+([ ][a-zA-Z]*)*$/;
            if (document.getElementById('Productname').value.match(nameRegex))
            {
                document.getElementById('nameError').innerHTML = "";
                validName = true;
            } else {
                document.getElementById('nameError').innerHTML = "Wrong Format";
            }
        }
        function checkNumber()
        {
            var nameRegex = /[0-9]+.[0-9]+/;
            if (document.getElementById('Productnumber').value.match(numberRegex))
            {
                document.getElementById('numberError').innerHTML = "";
                validNumber = true;
            } else {
                document.getElementById('numberError').innerHTML = "Wrong Format";
            }
        }
        function checkUrl()
        {
            var urlRegex = /<^(https?|ftp|file):/ / [ - a - zA - Z0 - 9 + & @#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>/;
                    if (document.getElementById('Productnumber').value.match(urlRegex))
            {
                document.getElementById('urlError').innerHTML = "";
                validUrl = true;
            } else {
                document.getElementById('urlError').innerHTML = "Wrong Format";
            }
        }


    </script>
    <body>

        <form method="post" onsubmit="submitForm()" action="AddProduct.java">
            <fieldset>
                <legend>Add Product:</legend>
                Product name:<br>
                <input type="text" id="Productname" placeholder="Enter Name" onblur="checkName()" required >
                <br>
                <label id="nameError"></label>
                <br>
                Product price:<br>
                <input type="number" id="Productprice" placeholder="Enter price" onblur="checkNumber()" required>
                <br>
                <label id="priceError"></label>
                <br>
                Product category:<br>
                <input type="text" id="Productcategory"  placeholder="Enter category" onblur="checkName()" required>
                <br>
                <label id="categoryError"></label>
                <br>
                Product amount:<br>
                <input type="number" id="Productamount"  placeholder="Enter amount" onblur="checkNumber()" required>
                <br>
                <label id="amountError"></label>
                <br>
                Product imgurl:<br>
                <input type="text" id="imgurl" placeholder="Enter imgurl" onblur="checkUrl()" required>
                <br>
                <label id="imgurlError"></label>
                <br>
                Product description:<br>
                <input type="text" id="description" placeholder="Enter description" onblur="checkName()" required>
                <br>
                <label id="descriptionError"></label>
                <br>
                <br>
                <input type="submit" value="Submit" >
            </fieldset>
        </form>

    </body>
</html>
