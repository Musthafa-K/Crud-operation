
function fun() {

    var valid = true;
    var firstName = document.getElementById('firstName').value.trim();
    var lastName = document.getElementById('lastName').value.trim();
    var username = document.getElementById('username').value.trim();
    var email = document.getElementById('email').value.trim();
    var dob = document.getElementById('dob').value.trim();
    var phoneNumber = document.getElementById('phoneNumber').value.trim();
    var password = document.getElementById('password').value.trim();
    var confirmPassword = document.getElementById('confirmPassword').value.trim();

    const isValidEmail = email => {
        const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    };

    if (firstName == '') {
        valid = false;
        var com = document.getElementById('efirstName')
        com.innerHTML = "*  Please enter your first name"
    } else {
        document.getElementById('efirstName').innerHTML = '';
    }

    if (lastName == '') {
        valid = false;
        var com = document.getElementById('elastName')
        com.innerHTML = "*  Please enter your last name"
    } else {
        document.getElementById('elastName').innerHTML = '';
    }
    if (username == '') {
        valid = false;
        var com = document.getElementById('eusername')
        com.innerHTML = "*  Please enter your username"
    } else {
        document.getElementById('eusername').innerHTML = '';
    }

    if(email =='') {
        valid=false;
        var com=document.getElementById('eemail')
        com.innerHTML="* Please enter your email"
    } else if (!isValidEmail(email)) {
        valid=false;
        var com=document.getElementById('eemail')
        com.innerHTML="* Please enter your validate email"
    } else {
       document.getElementById('eemail').innerHTML='';
    }

    if (dob == '') {
        valid = false;
        var com = document.getElementById('edob')
        com.innerHTML = "*  Please enter your date of birth"
    } else {
        document.getElementById('edob').innerHTML = '';
    }
    if (phoneNumber == '') {
        valid = false;
        var com = document.getElementById('ephoneNumber')
        com.innerHTML = "*  Please enter your phone number"
    } else if (phoneNumber.length < 10 || phoneNumber.length > 10) {
        valid = false;
        var com = document.getElementById('ephoneNumber')
        com.innerHTML = "*   Phone number should be 10 digit"
    } else {
        document.getElementById('ephoneNumber').innerHTML = '';
    }

    if (password == '') {
        valid = false;
        var com = document.getElementById('epassword')
        com.innerHTML = "*  Please enter your password"
    } else if (password.length < 4) {
        valid = false;
        var com = document.getElementById('epassword')
        com.innerHTML = "* Password should be 4 digit"
    } else {
        document.getElementById('epassword').innerHTML = '';
    }


    if (confirmPassword == '') {
        valid = false;
        var com = document.getElementById('econfirmPassword')
        com.innerHTML = "*  Please enter your confirm password"
    }else if(password!=confirmPassword){
        valid=false;
        var com=document.getElementById('econfirmPassword')
        com.innerHTML=" * password does not match"
    }else {
        document.getElementById('econfirmPassword').innerHTML='';
    }


    return valid;



}





































































































































































