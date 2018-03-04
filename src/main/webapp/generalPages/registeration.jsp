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
            <form method="post" action="SignUpServlet" 
                  onsubmit=" beforeSubmit();">
                <!--return submitForm();-->
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
                    <input type="text" placeholder="Enter Email" maxlength="50" id="uemail" name="uemail" onblur="checkEmail()" required>


                    <label id="emailError">${invalidEmail}</label>
                    <br>
                    <label for="upassword"><b>Password</b></label>
                    <br>
                    <input type="password" placeholder="Enter Password" maxlength="50" id="upassword" name="upassword" onblur="checkPassword()" required>
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
                    <div>
                        <button type="submit">Sign Up</button>
                    </div>
                </div>
                <input type="hidden" id="uCategory" name="uCategory" value="done">
                <input type="hidden" id="userJob" name="userJob" value="done">
            </form>

        </div>
        <c:remove var="invalidName" scope="application" />
        <c:remove var="invalidAddress" scope="application" />
        <c:remove var="invalidEmail" scope="application" />
        <c:remove var="invalidDate" scope="application" />
        <c:remove var="invalidPassword" scope="application" />
        <c:remove var="invalidCreditLimit" scope="application" />
    </body>
</html>