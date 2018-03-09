/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function checkEmailExistance()
{
    var valid = '';
    $.ajax({
        url: "LoginServlet",
        type: 'GET',
        contentType: 'application/json',
        data: {'lemail': document.getElementById('loginemail').value},
        error: function (xhr, status, error) {
            console.log(xhr);
            console.log(status);
            console.log(error);
        },
        success: function (data)
        {
            console.log("login check");
            $("#loginEmailError").text(data);
            console.log(data);
            if (data !== null && data !== '')
            {
                valid = false;
                console.log("login invalid");
            } else
            {
                valid = true;
                console.log("login valid");
            }
        }});
    return valid;
}
