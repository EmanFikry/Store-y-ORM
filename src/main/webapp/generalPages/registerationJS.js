var validName = false;
var validEmail = false;
var validPass = false;

function submitForm()
{
    if (validName && validEmail && validPass)
    {
        return true;
    } else
    {
        return false;
    }
}

function readLocalStorage()
{
    document.getElementById("uname").value = localStorage.getItem("fullname");
    document.getElementById("uemail").value = localStorage.getItem("email");
    document.getElementById("uaddress").value = localStorage.getItem("address");
    document.getElementById("ubd").value = localStorage.getItem("birthdate");
    document.getElementById("ucreditLimit").value = localStorage.getItem("creditLimit");
}
function beforeSubmit()
{
    localStorage.setItem("fullname", document.getElementById('uname').value);
    localStorage.setItem("email", document.getElementById('uemail').value);
    localStorage.setItem("address", document.getElementById('uaddress').value);
    localStorage.setItem("birthdate", document.getElementById('ubd').value);
    localStorage.setItem("creditLimit", document.getElementById('ucreditLimit').value);

    document.getElementById('userJob').value = document.getElementById("uJob").value;

    var checkedValue = '';
    var inputElements = document.getElementsByClassName('uInterests');
    for (var i = 0; inputElements[i]; i++) {
        if (inputElements[i].checked) {
            checkedValue = checkedValue + inputElements[i].value + ";";
        }
    }
    if (checkedValue != null) {
        document.getElementById('uCategory').value = checkedValue;
    }
}

function checkPassword()
{
    if (document.getElementById('upassword').value === document.getElementById('uconfirmPassword').value)
    {
        document.getElementById('passwordError').innerHTML = "";
        validPass = true;
        console.log(validPass);
    } else {
        document.getElementById('passwordError').innerHTML = "Passwords do not match";
    }
}

function checkEmail()
{
    var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (emailRegex.test(document.getElementById('uemail').value))
    {
        document.getElementById('emailError').innerHTML = "";
        validEmail = true;
        console.log(validEmail);
    } else {
        document.getElementById('emailError').innerHTML = "Wrong Format";
    }
}

function checkName()
{
    var nameRegex = /^[a-zA-Z]+([ ][a-zA-Z]*)*$/;
    if (document.getElementById('uname').value.match(nameRegex))
    {
        document.getElementById('nameError').innerHTML = "";
        validName = true;
        console.log(validName);
    } else {
        document.getElementById('nameError').innerHTML = "Wrong Format";
    }
}
