/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function  updateProducts()
{
    console.log("hereeeeeeeeeeeee 123344");
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
            console.log("hereeeeeeeeeeeee");
            var productRender = '';
            var mainProductDiv = document.getElementsByClassName("agileinfo_new_products_grids");
            for (i = 0; i < data.length; i++)
            {
//                data[i].imgURL
//                data[i].name
//                data[i].price
//                data[i].category
//                data[i].amount
//                data[i].description

                productRender = productRender + '<div class="col-md-3 agileinfo_new_products_grid">' +
                        '<div class="agile_ecommerce_tab_left agileinfo_new_products_grid1">' +
                        '<div class="hs-wrapper hs-wrapper1">' +
                        '<img src="' + data[i].imgURL + '"class="img - responsive"/>' +
                        '<div class="w3_hs_bottom w3_hs_bottom_sub">' +
                        '<ul><li>' +
                        '<a href="#" data-toggle="modal" data-target="#myModal5">' +
                        '<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>' +
                        '</li></ul></div></div>' +
                        '<h5><a href = "single.html" >' + data[i].name + '</a></h5>' +
                        '<div class="simpleCart_shelfItem">' +
                        '<p><i class = "item_price"> $' + data[i].price + '</i></p>' +
                        '<form action="#" method="post">' +
                        '<input type="hidden" name="cmd" value="_cart>' +
                        '<input type="hidden" name="add" value="1">' +
                        '<input type="hidden" name="id" value="' + data[i].recID + '">' +
                        '<input type="hidden" name="w3ls_item" value="' + data[i].name + '">' +
                        '<input type="hidden" name="amount" value="' + data[i].price + '">' +
                        '<button type="submit" class="w3ls-cart">Add to cart</button>\n\
                        </form></div></div></div>';
                
                
            }
            mainProductDiv[0].innerHTML = productRender;

        }
    });
}

