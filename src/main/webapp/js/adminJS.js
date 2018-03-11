var users_link = document.getElementById('users_link');
var products_link = document.getElementById('products_link');
var add_product_link = document.getElementById('add_products_link');
var users_table = document.getElementById('customers');
var products_table = document.getElementById('Products');

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
    var checkExistance = document.getElementById('Productname');
    if (checkExistance !== null) {
        if (document.getElementById('Productname').value.match(nameRegex))
        {
            document.getElementById('nameError').innerHTML = "";
            validName = true;
        } else {
            document.getElementById('nameError').innerHTML = "Wrong Format";
        }
    }
}
function checkNumber()
{
    var nameRegex = /[0-9]+.[0-9]+/;
    var checkExistance = document.getElementById('Productnumber');
    if (checkExistance !== null) {
        if (document.getElementById('Productnumber').value.match(numberRegex))
        {
            document.getElementById('numberError').innerHTML = "";
            validNumber = true;
        } else {
            document.getElementById('numberError').innerHTML = "Wrong Format";
        }
    }
}
users_link.onclick = function () {
    users_table.style.display = "table";
    products_table.style.display = "none";

    users_link.style.background = "#fff";
    users_link.style.color = "#000";
    products_link.style.background = "#39424a";
    products_link.style.color = "#fff";
    add_product_link.style.background = "#39424a";
    add_product_link.style.color = "#fff";

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
            console.log("ajax customer");
            document.getElementById("customers").innerHTML = '';
            for (i = 0; i < data.length; i++) {
                $("#customers").append('<tr><td>' + data[i].name
                        + '</td><td>' + data[i].email + '</td><td>' + data[i].address +
                        '</td><td>'
                        + '<input id="V" type="button" value="MORE" onclick="userShowMore(' + data[i].recID + ')"/>' + '</td></tr>');

            }
        }
    });
}
products_link.onclick = function () {
    products_table.style.display = "table";
    users_table.style.display = "none";
    products_link.style.background = "#fff";
    users_link.style.background = "#39424a";
    products_link.style.color = "#000";
    users_link.style.color = "#fff";
    add_product_link.style.background = "#39424a";
    add_product_link.style.color = "#fff";
    $.ajax({
        url: "ViewProduct",
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
            console.log("hereeeeeeeeeeeee");

            document.getElementById("Products").innerHTML = '';
            for (i = 0; i < data.length; i++) {
                var updateButton = data[i].recID + "U";
                var deleteButton = data[i].recID + "D";
                var moreButton = data[i].recID + "V";

                $("#Products").append(
                        '<tr><td>' + data[i].name + '</td>'
                        + '<td>' + data[i].price + '</td>'
                        + '<td>' + data[i].category + '</td>'
                        + '<td>' + '<input id="U" type="button" value="UPDATE" onclick="Update(' + data[i].recID + ')"/>'
                        + '</td>'
                        + '<td>' + '<input id="D" type="button" value="DELETE" onclick="Delete(' + data[i].recID + ')"/>'
                        + '</td>'
                        + '<td>' + '<input id="V" type="button" value="MORE" onclick="ShowMore(' + data[i].recID + ')"/>'
                        + '</td></tr>');
                document.getElementById("U").id = updateButton;
                document.getElementById("D").id = deleteButton;
                document.getElementById("V").id = moreButton;
            }
        }
    });
}
add_product_link.onclick = function () {
    products_table.style.display = "none";
    users_table.style.display = "none";
    products_link.style.background = "#39424a";
    users_link.style.background = "#39424a";
    products_link.style.color = "#fff";
    users_link.style.color = "#fff";
    add_product_link.style.background = "#fff";
    add_product_link.style.color = "#000";

    document.getElementById("addProductDiv").innerHTML = '';
    $("#addProductDiv").append(
            '<form method=post action="AddProduct">' +
            '<fieldset> <legend>Add Product:</legend>' +
            'Product name:<br>' +
            '<input type="text" name="productName"  id="productName" maxlength="50"  placeholder="Enter Name" onblur="checkName()" required >' +
            '<br>' +
            '<label id="nameError"></label>' +
            '<br>' +
            'Product price:<br>' +
            '<input type="number" id="productPrice" name="productPrice" maxlength="50" placeholder="Enter price" onblur="checkNumber()" required>' +
            '<br>' +
            '<label id="priceError"></label>' +
            '<br>' +
            'Product category:<br>' +
            '<input type="text" id="productCategory" name="productCategory"  maxlength="50" placeholder="Enter category" onblur="checkName()" required>' +
            '<br>' +
            '<label id="categoryError"></label>' +
            '<br>' +
            'Product amount:<br>' +
            '<input type="number" id="productAmount" name="productAmount"  maxlength="50" placeholder="Enter amount" onblur="checkNumber()" required>' +
            '<br>' +
            '<label id="amountError"></label>' +
            '<br>' +
            'Product imgurl:<br>' +
            '<label for="profile_pic">Choose file to upload</label>' +
            '<br>' +
            '<input type="file" id="profile_pic" name="profile_pic" accept=".jpg, .jpeg, .png" ><br>' +
            '<br>' +
            'Product description:<br>' +
            '<input type="text" id="productDescription" name="productDescription" maxlength="100" placeholder="Enter description" onblur="checkName()" required>' +
            '<br>' +
            '<label id="descriptionError"></label>' +
            '<br> <br> <input type="submit" value="Submit" > </fieldset> </form>');
}
function load_it() {
    users_link.style.background = "#fff";
    users_link.style.color = "#000";

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
            console.log("ajax customer");
            document.getElementById("customers").innerHTML = '';
            for (i = 0; i < data.length; i++) {
                $("#customers").append('<tr><td>' + data[i].name
                        + '</td><td>' + data[i].email + '</td><td>' + data[i].address +
                        '</td><td>'
                        + '<input id="V" type="button" value="MORE" onclick="userShowMore(' + data[i].recID + ')"/>' + '</td></tr>');

            }
        }
    });
}

var req = null;
function Update(id)
{
    if (window.XMLHttpRequest)
        req = new XMLHttpRequest();
    else if
            (window.ActiveXObject)
        req = new ActiveXObject(Microsoft.XMLHTTP);

    req.onreadystatechange = openUpdateScreen;

    url = "ViewProduct";
    req.open("POST", url, true);
    req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    req.send("id=" + id);
}
function openUpdateScreen() {
    if (req.readyState == 4 && req.status == 200) {
        xmlvalue = req.responseText;
        window.location.href = "UpdateProduct.jsp"
    }
}
function openUpdateScreen() {
    if (req.readyState == 4 && req.status == 200) {
        xmlvalue = req.responseText;
        window.location.href = "updateProduct.jsp"
    }
}


function Delete(id)
{
    if (window.XMLHttpRequest)
        req = new XMLHttpRequest();
    else if
            (window.ActiveXObject)
        req = new ActiveXObject(Microsoft.XMLHTTP);

    req.onreadystatechange = refrehPage;

    url = "RemoveProduct";
    req.open("POST", url, true);
    req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    req.send("id=" + id);
}

function refrehPage() {
    if (req.readyState == 4 && req.status == 200) {
        xmlvalue = req.responseText;
        location.reload();
    }
}

function userShowMore(id)
{
    $.ajax({
        url: "UserDetailsServlet",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        data: {"userid": id},
        error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
        },
        success: function (data)
        {
            document.getElementById("userDialog").innerHTML = '';
            $("#userDialog").append(
                    '<form> <h1>Information</h1> <fieldset> <label for="name">Name:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.name + '"/>' +
                    '<br>' +
                    '<label for="price">Email:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.email + '"/>' +
                    '<br>' +
                    '<label for="price">Address:</label>' +
                    '<br>' +
                    '<input type="text"  readonly value="' + data.address + '"/>' +
                    '<br>' +
                    '<label for="price">Job:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.job + '"/>' +
                    '<br>' +
                    '<label for="price">Birthdate:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.birthdate + '"/>' +
                    '<br>' +
                    '<label for="price">credit Limit:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.creditLimit + '"/>' +
                    '<br>' +
                    '</fieldset> <button type="button" onclick="closePopup()">OK</button> </form>'
                    );

            // private String imgURL;
        }
    });
}
function ShowMore(id) {

    $.ajax({
        url: "AdminDisplayProductDetailsServlet",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        data: {"id": id},
        error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
        },
        success: function (data)
        {
            document.getElementById("disDialog").innerHTML = '';
            $("#disDialog").append(
                    '<form> <h1>Information</h1> <fieldset> <label for="name">Name:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.name + '"/>' +
                    '<br>' +
                    '<label for="price">Price:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.price + '"/>' +
                    '<br>' +
                    '<label for="price">Category:</label>' +
                    '<br>' +
                    '<input type="text"  readonly value="' + data.category + '"/>' +
                    '<br>' +
                    '<label for="price">Amount:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.amount + '"/>' +
                    '<br>' +
                    '<label for="price">Description:</label>' +
                    '<br>' +
                    '<input type="text" readonly value="' + data.description + '"/>' +
                    '<br>' +
                    '</fieldset> <button type="button" onclick="closePopup()">OK</button> </form>'
                    );

            // private String imgURL;
        }
    });
}

function closePopup() {
    document.getElementById('disDialog').style.display = "none";
}


