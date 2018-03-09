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

        function handleDrop(e) {
            e.stopPropagation(); // Stops some browsers from redirecting.
            e.preventDefault();

            var files = e.dataTransfer.files;
            for (var i = 0, f; f = files[i]; i++) {
                 files = document.getElementById(profile_pic).files;
                // Read the File objects in this FileList.
            }
        }
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
            var urlRegex = /(([\w]+:)?\/\/)?(([\d\w]|%[a-fA-f\d]{2,2})+(:([\d\w]|%[a-fA-f\d]{2,2})+)?@)?([\d\w][-\d\w]{0,253}[\d\w]\.)+[\w]{2,63}(:[\d]+)?(\/([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)*(\?(&?([-+_~.\d\w]|%[a-fA-f\d]{2,2})=?)*)?(#([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)?/;
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

        <form method=post ENCTYPE="MULTIPART/FORM-DATA" action="AddProduct">
            <fieldset>
                <legend>Add Product:</legend>
                Product name:<br>
                <input type="text" name="productName"  id="productName" maxlength="50"  placeholder="Enter Name" onblur="checkName()" required >
                <br>
                <label id="nameError"></label>
                <br>
                Product price:<br>
                <input type="number" id="productPrice" name="productPrice" maxlength="50" placeholder="Enter price" onblur="checkNumber()" required>
                <br>
                <label id="priceError"></label>
                <br>
                Product category:<br>
                <input type="text" id="productCategory" name="productCategory"  maxlength="50" placeholder="Enter category" onblur="checkName()" required>
                <br>
                <label id="categoryError"></label>
                <br>
                Product amount:<br>
                <input type="number" id="productAmount" name="productAmount"  maxlength="50" placeholder="Enter amount" onblur="checkNumber()" required>
                <br>
                <label id="amountError"></label>
                <br>
                Product imgurl:<br>
                <label for="profile_pic">Choose file to upload</label>
                <br>
                <input type="file" id="profile_pic" name="profile_pic" 
                       accept=".jpg, .jpeg, .png" ><br>

                <br>
                Product description:<br>
                <input type="text" id="productDescription" name="productDescription" maxlength="100" placeholder="Enter description" onblur="checkName()" required>
                <br>
                <label id="descriptionError"></label>
                <br>
                <br>

                <input type="submit" value="Submit" >
            </fieldset>
        </form>

    </body>
</html>
