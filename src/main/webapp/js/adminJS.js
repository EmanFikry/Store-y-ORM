var users_link = document.getElementById('users_link');
var products_link = document.getElementById('products_link');
var add_product_link = document.getElementById('add_products_link');
var users_table = document.getElementById('customers');
var products_table = document.getElementById('Products');

users_link.onclick = function () {
    users_table.style.display = "table";
    products_table.style.display = "none";

    users_link.style.background = "#fff";
    users_link.style.color = "#000";
    products_link.style.background = "#39424a";
    products_link.style.color = "#fff";
    add_product_link.style.background = "#39424a";
    add_product_link.style.color = "#fff";
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
            var productRender = '';

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
}
function load_it() {
    users_link.style.background = "#fff";
    users_link.style.color = "#000";
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

    name = document.getElementById("name" + id).innerHTML;
    price = document.getElementById("price" + id).innerHTML;
    category = document.getElementById("category" + id).innerHTML;
    amount = document.getElementById("amount" + id).innerHTML;
    imgURL = document.getElementById("imgURL" + id).innerHTML;
    description = document.getElementById("description" + id).innerHTML;

    url = "ViewProduct";
    req.open("POST", url, true);
    req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    req.send("id=" + id
            + "&name=" + name
            + "&price=" + price
            + "&category=" + category
            + "&amount=" + amount
            + "&imgURL=" + imgURL
            + "&description=" + description
            );
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

function ShowMore(id) {
    window.location.href = "ViewProduct.jsp";
}

function closePopup() {
    document.getElementById('disDialog').style.display = "none";
}


