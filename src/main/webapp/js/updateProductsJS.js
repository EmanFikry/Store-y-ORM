/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function  updateProducts()
{
    $.ajax({
        url: "DisplayProductsServlet",
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
            console.log(check);
            var productRender = '';
            var mainProductDiv = document.getElementsByClassName("agileinfo_new_products_grids");
            for (i = 0; i < data.length; i++)
            {
                productRender = productRender + '<div class="col-md-3 agileinfo_new_products_grid">' +
                        '<div class="agile_ecommerce_tab_left agileinfo_new_products_grid1">' +
                        '<div class="hs-wrapper hs-wrapper1">' +
                        '<img src="' + data[i].imgURL + '"class="img - responsive"/>' +
                        '<img src="' + data[i].imgURL + '"class="img - responsive"/>' +
                        '<div class="w3_hs_bottom w3_hs_bottom_sub">' +
                        '<ul><li>' +
                        '<a href="single.html">' +
                        '<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>' +
                        '</li></ul></div></div>' +
                        '<h5><a href = "single.html" >' + data[i].name + '</a></h5>' +
                        '<div class="simpleCart_shelfItem">' +
                        '<p><i class = "item_price"> $' + data[i].price + '</i></p>' +
                        ' <div id="productDiv">' +
                        '<input type="hidden" name="cmd" value="_cart>' +
                        '<input type="hidden" name="add" value="1">' +
                        '<input type="hidden" id="quantity" name="quantity" value="' + data[i].amount + '">' +
                        '<input type="hidden" id="name" name="w3ls_item" value="' + data[i].name + '">' +
                        '<input type="hidden" id="price" name="amount" value="' + data[i].price + '">' +
                        '<input type="hidden" id="id" name="id" value="' + data[i].recID + '">';

                if (check) {
                    productRender += '<button onclick="addToCart(this);" class="w3ls-cart">Add to cart</button>';
                }
                productRender += '</div></div></div></div>';
                console.log("test hereeeeeeeee");
            }
            mainProductDiv[0].innerHTML = productRender;
        }
    });
}

