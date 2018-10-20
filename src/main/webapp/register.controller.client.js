function f() {

    var registerbtn = jQuery('#registerbtn');
    var usernameFld = $('#username');
    var passwordFld = $('#password');
    var password2Fld = $('#password2');

    registerbtn.click(registerHandler); //no parentheses

    function registerHandler() {
        var usernameStr = usernameFld.val();
        var passwordStr = passwordFld.val();
        var password2Str = password2Fld.val();

        var userObj = {
            username: usernameStr,
            password: passwordStr
        };

        var userObjStr = JSON.stringify(userObj);

        fetch('/register',{
            method:'post',
            body:userObjStr,
            headers:{
                'Content-Type': 'application/json'
            }
        }).then(registrationSuccessful, registrationFailed);


    }

    function registrationSuccessful() {
        window.location.href = "/profile.client.html" ;
    }


    function  registrationFailed() {
        alert("oops")
    }


}

f();
