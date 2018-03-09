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
