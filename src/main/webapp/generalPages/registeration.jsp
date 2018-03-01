<%-- 
    Document   : registration
    Created on : Feb 23, 2018, 10:18:20 AM
    Author     : Eman-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<c:url value="/generalPages/registerationJS.js" />"></script>
    </head>
    <body onload="readLocalStorage()">
        <div>
            <center>
                <form method="post" action="SignUpServlet" 
                      onsubmit=" beforeSubmit(); return submitForm();">
                    <!--return submitForm();-->
                    <div>
                        <h1>Sign Up</h1>
                        <label for="uname"><b>Name</b></label>
                        <br>
                        <input type="text" placeholder="Enter Name" maxlength="100" id="uname" name="uname" onblur="checkName()" required>
                        <br>
                        <label id="nameError">${invalidName}</label>

                        <label for="ubd"><b>Birthday</b></label>
                        <br>
                        <input type="date" max="2000-02-28" name="ubd" id="ubd" required>
                        <br>

                        <label for="uemail"><b>Email</b></label>
                        <br>
                        <input type="text" placeholder="Enter Email" maxlength="50" id="uemail" name="uemail" onblur="checkEmail()" required>
                        <br>

                        <label id="emailError"></label>

                        <label for="upassword"><b>Password</b></label>
                        <br>
                        <input type="password" placeholder="Enter Password" maxlength="50" id="upassword" name="upassword" onblur="checkPassword()" required>
                        <br>

                        <label for="uconfirmPassword"><b>Confirm Password</b></label>
                        <br>
                        <input type="password" placeholder="Confirm Password" maxlength="50" id="uconfirmPassword" name="uconfirmPassword" onblur="checkPassword()" required>
                        <br>

                        <label id="passwordError"></label>

                        <label for="ucreditLimit"><b>Credit Limit</b></label>
                        <br>
                        <input type="number" min="0" placeholder="Enter Credit Limit" id="ucreditLimit" name="ucreditLimit" required>
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
                        <br>
                        <div>
                            <button type="submit">Sign Up</button>
                        </div>
                    </div>
                    <input type="hidden" id="uCategory" name="uCategory" value="done">
                    <input type="hidden" id="userJob" name="userJob" value="done">
                </form>
            </center>

        </div>
    </body>
</html>