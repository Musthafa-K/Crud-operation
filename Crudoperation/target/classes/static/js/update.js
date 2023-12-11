
function upd() {
    console.log("In update function ");
    var valid = true;
    var firstName = document.getElementById('firstName').value.trim();
    var lastName = document.getElementById('lastName').value.trim();
    var username = document.getElementById('username').value.trim();
    var email = document.getElementById('email').value.trim();
    var dob = document.getElementById('dob').value.trim();
    var phoneNumber = document.getElementById('phoneNumber').value.trim();

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
        console.log("in email function");
        valid=false;
        var com=document.getElementById('eemail')
        console.log("In email function2");
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



    return valid;



}





































































































































































