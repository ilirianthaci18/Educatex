const emailReg = /^[A-Za-z0-9+_.-]+@(.+)$/;

function loginValidimi () {
    const email = document.getElementById('email');
    const password = document.getElementById('pass');

    if(email.value == "") {
        alert("Please enter your email!");
        return false;
    }
    else if(!emailReg.test(email.value)){
        alert("Please enter a valid email address!");
        return false;
    }
    else if (password.value == "") {
        alert("Please enter your password!");
        return false;
    }
    else if (password.value.length < 7) {
        alert("Password must contain at least 8 characters!");
        return false;
    }
    else{
        window.location.href = "profile.html";
        return false;
    }
}
