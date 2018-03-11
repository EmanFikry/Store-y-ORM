<%-- 
    Document   : home
    Created on : Mar 4, 2018, 7:17:16 PM
    Author     : Eman-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Store-Y</title>
        <!-- for-mobile-apps -->
        <meta HTTP-EQUIV="refresh"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Electronic Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
              SmartPhone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } 
            var check =${sessionScope.userObject != null};
        </script>
        <!-- //for-mobile-apps -->
        <!-- Custom Theme files -->
        <meta charset="utf-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/fasthover.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
        <script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>


        <!-- //Custom Theme files -->
        <!-- font-awesome icons -->
        <link href="css/font-awesome.css" rel="stylesheet">
        <!-- //font-awesome icons -->
        <!-- js -->
        <script src="js/jquery.min.js"></script>
        <link rel="stylesheet" href="css/jquery.countdown.css" /> <!-- countdown -->
        <!-- //js -->
        <!-- web fonts -->
        <link href='//fonts.googleapis.com/css?family=Glegoo:400,700' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <!-- //web fonts -->
        <!-- start-smooth-scrolling -->
        <script type="text/javascript">
jQuery(document).ready(function ($) {
    $(".scroll").click(function (event) {
        event.preventDefault();
        $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
    });
});
        </script>
        <!-- //end-smooth-scrolling -->


        <!-- Add Check For cookies in all pages -- -->
        <script type="text/javascript">
            function checkCookies() {
                var cookieEnabled = (navigator.cookieEnabled) ? true : false;
                //if not IE4+ nor NS6+
                if (typeof navigator.cookieEnabled == "undefined" && !cookieEnabled) {
                    document.cookie = "testcookie"
                    cookieEnabled = (document.cookie.indexOf("testcookie") != -1) ? true : false
                }

                if (!cookieEnabled) {
                    window.location.href = "/error.html";
                }
            }


        </script>

    </head>
    <body onload="checkCookies();
            setInterval('updateProducts()', 1000)">
        <noscript>
        <style type="text/css">
            .pagecontainer {display:none;}
        </style>
        <div class="noscriptmsg">
            You don't have javascript enabled.  Good luck with that.
        </div>
        </noscript>
        <div class="pagecontainer">
            <!-- for bootstrap working -->
            <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
            <!-- //for bootstrap working -->
            <!-- header modal -->
            <div class="modal fade" id="myModal88" tabindex="-1" role="dialog" aria-labelledby="myModal88"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;</button>
                            <h4 class="modal-title" id="myModalLabel">Don't Wait, Login now!</h4>
                        </div>
                        <div class="modal-body modal-body-sub">
                            <div class="row">
                                <div class="col-md-8 modal_body_left modal_body_left1" style="border-right: 1px dotted #C2C2C2;padding-right:3em; width:80%;">
                                    <div class="sap_tabs">
                                        <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
                                            <ul>
                                                <li class="resp-tab-item" aria-controls="tab_item-0"><span>Sign in</span></li>
                                                <li class="resp-tab-item" aria-controls="tab_item-1"><span>Sign up</span></li>
                                            </ul>
                                            <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                                                <div class="facts">
                                                    <div class="register">
                                                        <form action="LoginServlet" method="post" 
                                                              onsubmit="return loginSubmit();">
                                                            <h1>Sign In</h1>
                                                            <br>
                                                            <label for="loginemail"><b>Email</b></label>
                                                            <br>
                                                            <input type="text" placeholder="Enter Email" id="loginemail" name="loginemail"
                                                                   onblur="checkEmailExistance()" required>
                                                            <label id="loginEmailError">${loginInvalidEmail}</label>
                                                            <br>
                                                            <br>
                                                            <label for="loginpas"><b>Password</b></label>
                                                            <br>
                                                            <input type="password" placeholder="Enter Password" id="loginpas" name="loginpas"
                                                                   required>
                                                            <label>${loginInvalidPassword}</label>
                                                            <br>
                                                            <div class="sign-up">
                                                                <input type="submit" value="Sign in"/>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
                                                <div class="facts">
                                                    <div class="register">
                                                        <form method="post" action="SignUpServlet" onsubmit="beforeSubmit();
                                                                return submitForm();">

                                                            <div>
                                                                <h1>Sign Up</h1>
                                                                <label for="uname"><b>Name</b></label>
                                                                <br>
                                                                <input type="text" placeholder="Enter Name" maxlength="100" id="uname" name="uname" onblur="checkName()" required>

                                                                <label id="nameError">${invalidName}</label>
                                                                <br>
                                                                <label for="ubd"><b>Birthday</b></label>
                                                                <br>
                                                                <input type="date" max="2000-02-28" name="ubd" id="ubd" required>

                                                                <label id="dateError">${invalidDate}</label>
                                                                <br>
                                                                <label for="uemail"><b>Email</b></label>
                                                                <br>
                                                                <input type="email" placeholder="Enter Email" maxlength="50" id="uemail" name="uemail" onblur="checkEmail()" required>


                                                                <label id="emailError">${invalidEmail}</label>
                                                                <br>
                                                                <label for="upassword"><b>Password</b></label>
                                                                <br>
                                                                <input type="password" placeholder="Enter Password" maxlength="50" id="upassword" name="upassword" onblur="checkPasswordStrength()" required>
                                                                <label id="passStrength"></label>
                                                                <br>

                                                                <label for="uconfirmPassword"><b>Confirm Password</b></label>
                                                                <br>
                                                                <input type="password" placeholder="Confirm Password" maxlength="50" id="uconfirmPassword" name="uconfirmPassword" onblur="checkPassword()" required>


                                                                <label id="passwordError">${invalidPassword}</label>
                                                                <br>
                                                                <label for="ucreditLimit"><b>Credit Limit</b></label>
                                                                <br>
                                                                <input type="number" min="1" placeholder="Enter Credit Limit" id="ucreditLimit" name="ucreditLimit" required>

                                                                <label id="creditLimitError">${invalidCreditLimit}</label>
                                                                <br>
                                                                <label for="uInterests"><b>Interests</b></label>
                                                                <br>
                                                                <input type="checkbox" class="uInterests" value="Baby" />Baby<br/>
                                                                <input type="checkbox" class="uInterests" value="Beauty" />Beauty<br/>
                                                                <input type="checkbox" class="uInterests" value="Computers" />Computers<br/>
                                                                <input type="checkbox" class="uInterests" value="Home Decor & Furniture" />Home Decor & Furniture<br/>
                                                                <input type="checkbox" class="uInterests" value="Jewelry & Accessories" />Jewelry & Accessories<br/>
                                                                <input type="checkbox" class="uInterests" value="Mobile Phones, Tablets & Accessories" />Mobile Phones, Tablets & Accessories<br/>
                                                                <label for="uJob"><b>Job</b></label>
                                                                <br>
                                                                <select id="uJob">
                                                                    <option value="student">Student</option>
                                                                    <option value="teacher">Teacher</option>
                                                                    <option value="engineer">Engineer</option>
                                                                    <option value="doctor">Doctor</option>
                                                                    <option value="other">Other</option>
                                                                </select>
                                                                <br>
                                                                <label for="uaddress"><b>Address</b></label>
                                                                <br>
                                                                <input type="text" placeholder="Enter Address" maxlength="70" id="uaddress" name="uaddress" required>

                                                                <label id="AddressError">${invalidAddress}</label>
                                                                <br>
                                                            </div>
                                                            <input type="hidden" id="uCategory" name="uCategory" value="done">
                                                            <input type="hidden" id="userJob" name="userJob" value="done">

                                                            <div class="sign-up">
                                                                <input type="submit" value="Create Account"/>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
                                    <script type="text/javascript">
                                                                    $(document).ready(function () {
                                                                        $('#horizontalTab').easyResponsiveTabs({
                                                                            type: 'default', //Types: default, vertical, accordion
                                                                            width: 'auto', //auto or any width like 600px
                                                                            fit: true   // 100% fit in a container
                                                                        });
                                                                    });
                                    </script>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- header modal -->
            <!-- header -->
            <div class="header" id="home1">
                <div class="container">
                    <div class="w3l_login">
                        <a href="#" data-toggle="modal" data-target="#myModal88" style="margin-left:5px;"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
                        <br>
                        <c:if test="${sessionScope.userObject != null}">
                            <form action="SignOutServlet" method="get">
                                <button class="" type="submit"  value="" style="display:inline-block;background:#fff;color:#c566d4; border-width:0px;" id="log-btn">LogOut</button> 
                            </form>
                        </c:if>
                    </div>
                    <div class="w3l_logo" style="text-align:center;">
                        <h1 ><a href="index.html">Store-Y<span>Your stores. Your place.</span></a></h1>
                        <br>
                        <c:if test="${sessionScope.userObject != null}">
                            <button class="" type="button" name="checkout-btn" value="" style="display:inline-block;background:#fff;color:#c566d4; border-width:0px;" id="check-btn">Check Out</button>
                            <p>${sessionScope.userObject.name}</p>

                            <a href="editProfile.jsp" class="" style="display:inline-block;background:#fff;color:#c566d4; border-width:0px;" id="edit-btn">Edit Profile</a>
                        </c:if>
                    </div>
                    <div class="cart cart box_1">
                        <form action="#" method="post" class="last">
                            <input type="hidden" name="cmd" value="_cart" />
                            <input type="hidden" name="display" value="1" />
                            <button class="w3view-cart" type="submit" name="submit" value="" style="color:#fff;"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- //header -->
            <!-- navigation -->
            <div class="navigation" style="background:#ba3e9d;">
                <div class="container" >
                    <nav class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->

                    </nav>
                </div>
            </div>


            <!-- new-products -->
            <div class="new-products">
                <div class="container">
                    <h3>Products</h3>
                    <!--main div of products-->
                    <div class="agileinfo_new_products_grids">

                    </div>
                </div>
            </div>
            <div style="padding:10px; text-align: center;">
                <h3>Your Cart</h3>
                <div>
                    <table id="cart">
                        <tr>
                            <th>Product Name</th>
                            <th>Price</th>
                            <th>Amount</th>
                            <th>Add</th>
                            <th>Remove</th>
                        </tr>

                    </table>
                </div>
            </div>
            <!-- //new-products -->

            <!-- footer -->
            <div class="footer">
                <div class="container">
                    <div class="w3_footer_grids">
                        <div class="col-md-3 w3_footer_grid">
                            <h3>Contact</h3>
                            <p>Duis aute irure dolor in reprehenderit in voluptate velit esse.</p>
                            <ul class="address">
                                <li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>1234k Avenue, 4th block, <span>New York City.</span></li>
                                <li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="mailto:info@example.com">info@example.com</a></li>
                                <li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>+1234 567 567</li>
                            </ul>
                        </div>
                        <div class="col-md-3 w3_footer_grid">
                            <h3>Information</h3>
                            <ul class="info">
                                <li><a href="about.html">About Us</a></li>
                                <li><a href="mail.html">Contact Us</a></li>
                                <li><a href="codes.html">Short Codes</a></li>
                                <li><a href="faq.html">FAQ's</a></li>
                                <li><a href="products.html">Special Products</a></li>
                            </ul>
                        </div>
                        <div class="col-md-3 w3_footer_grid">
                            <h3>Category</h3>
                            <ul class="info">
                                <li><a href="products.html">Mobiles</a></li>
                                <li><a href="products1.html">Laptops</a></li>
                                <li><a href="products.html">Purifiers</a></li>
                                <li><a href="products1.html">Wearables</a></li>
                                <li><a href="products2.html">Kitchen</a></li>
                            </ul>
                        </div>
                        <div class="col-md-3 w3_footer_grid">
                            <h3>Profile</h3>
                            <ul class="info">
                                <li><a href="index.html">Home</a></li>
                                <li><a href="products.html">Today's Deals</a></li>
                            </ul>
                            <h4>Follow Us</h4>
                            <div class="agileits_social_button">
                                <ul>
                                    <li><a href="#" class="facebook"> </a></li>
                                    <li><a href="#" class="twitter"> </a></li>
                                    <li><a href="#" class="google"> </a></li>
                                    <li><a href="#" class="pinterest"> </a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                <div class="footer-copy">
                    <div class="footer-copy1">
                        <div class="footer-copy-pos">
                            <a href="#home1" class="scroll"><img src="images/arrow.png" alt=" " class="img-responsive" /></a>
                        </div>
                    </div>
                    <div class="container">
                        <p>&copy; 2017 Store-Y. All rights reserved</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- //footer -->
        <!-- cart-js -->
        <script src="js/minicart.js"></script>
        <script src="js/registerationJS.js"></script>
        <script src="js/updateProductsJS.js"></script>
        <script src="js/loginJS.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.2.0/zxcvbn.js"></script>




        <script>
                                                                    var listItems = [];

                                                                    $("#check-btn").click(function () {

                                                                    });

                                                                    function addToCart(el) {
                                                                        console.log(el.innerText);
                                                                        var button = el;
                                                                        var divParentOfButton = button.parentElement;
                                                                        console.log(divParentOfButton);
                                                                        var namefield = divParentOfButton.querySelector("#name").value;
                                                                        var pricefield = divParentOfButton.querySelector("#price").value;
                                                                        var idfield = divParentOfButton.querySelector("#id").value;
                                                                        console.log(namefield);
                                                                        addItems(namefield, pricefield, idfield);
                                                                    }

                                                                    function addItems(name, price, id) {
                                                                        console.log("passed name: " + name);
                                                                        for (var i = 0; i < listItems.length; i++) {
                                                                            console.log(listItems[i].name);
                                                                            if (listItems[i].name === name) {
                                                                                listItems[i].amount++;
                                                                                console.log(listItems);
                                                                                createTable(listItems);
                                                                                return;
                                                                            }
                                                                        }
                                                                        listItems.push({"name": name, "price": price, "amount": 1, "id": id});
                                                                        createTable(listItems);
                                                                        sendAjax();
                                                                    }
                                                                    function createTable(listItems) {

                                                                        var table = document.getElementById("cart");
                                                                        table.innerHTML = "<tr><th>Product Name</th><th>Price</th><th>Amount</th><th>Add</th><th>Remove</th></tr>";
                                                                        for (var i = 0; i < listItems.length; i++) {
                                                                            if (listItems[i].amount > 0) {

                                                                                var row = document.createElement("tr");
                                                                                var col_name = document.createElement("td");
                                                                                var col_price = document.createElement("td");
                                                                                var col_amount = document.createElement("td");
                                                                                var col_remove = document.createElement("td");
                                                                                var col_add = document.createElement("td");
                                                                                col_name.innerHTML = listItems[i].name;
                                                                                col_price.innerHTML = listItems[i].price;
                                                                                col_amount.innerHTML = listItems[i].amount;
                                                                                col_add.innerHTML = "<a onclick='inc(this)'>Add</a>";
                                                                                col_remove.innerHTML = "<a onclick='dec(this)'>Remove</a>";
                                                                                row.appendChild(col_name);
                                                                                row.appendChild(col_price);
                                                                                row.appendChild(col_amount);
                                                                                row.appendChild(col_add);
                                                                                row.appendChild(col_remove);
                                                                                var ulcart = document.getElementById("cart");
                                                                                ulcart.appendChild(row);
                                                                                console.log(listItems);
                                                                            }
                                                                        }

                                                                    }
                                                                    function inc(btn) {
                                                                        var td = btn.parentElement;
                                                                        var tr = td.parentElement;
                                                                        var nameTd = tr.childNodes[0];
                                                                        var amountTd = tr.childNodes[2];
                                                                        console.log(nameTd.textContent);
                                                                        for (var i = 0; i < listItems.length; i++) {
                                                                            if (listItems[i].name === nameTd.textContent) {
                                                                                listItems[i].amount++;
                                                                            }
                                                                        }
                                                                        console.log(listItems);
                                                                        createTable(listItems);
                                                                        sendAjax();
                                                                    }
                                                                    function dec(btn) {
                                                                        var td = btn.parentElement;
                                                                        var tr = td.parentElement;
                                                                        var nameTd = tr.childNodes[0];
                                                                        var amountTd = tr.childNodes[2];
                                                                        console.log(nameTd.textContent);
                                                                        for (var i = 0; i < listItems.length; i++) {
                                                                            if (listItems[i].name === nameTd.textContent) {
                                                                                listItems[i].amount--;
                                                                            }
                                                                        }
                                                                        console.log(listItems);
                                                                        createTable(listItems);
                                                                        sendAjax();
                                                                    }

                                                                    function sendAjax() {

                                                                        console.log('listItems');
                                                                        console.log(listItems);

                                                                        $.ajax({
                                                                            url: "UpdateCartServlet",
                                                                            type: 'POST',
                                                                            dataType: 'json',
                                                                            contentType: 'application/json',
                                                                            data: JSON.stringify(listItems),
                                                                            error: function (xhr, status, error) {
                                                                                console.log(xhr);
                                                                                console.log(status);
                                                                                console.log(error);
                                                                            }
                                                                        }
                                                                        );
                                                                    }

        </script>

        <!-- //cart-js -->
        <c:remove var="invalidName" scope="application" />
        <c:remove var="invalidAddress" scope="application" />
        <c:remove var="invalidEmail" scope="application" />
        <c:remove var="invalidDate" scope="application" />
        <c:remove var="invalidPassword" scope="application" />
        <c:remove var="invalidCreditLimit" scope="application" />

        <c:remove var="loginInvalidPassword" scope="application" />
        <c:remove var="loginInvalidEmail" scope="application" />

    </body>
</html>
