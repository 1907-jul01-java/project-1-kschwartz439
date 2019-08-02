function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    var param = "username="+username+"&password="+password;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "http://localhost:8080/movie-api/login", true);
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4 && xhr.status == 200){
            var JSONObject = xhr.responseText;
            if (JSONObject == "false"){
                window.location.assign("http://localhost:8080/movie-api");
            }
            if (JSONObject == "employee"){
                window.location.assign("http://localhost:8080/movie-api/employee.html");
            }
            if (JSONObject == "manager" || JSONObject == "admin"){
                window.location.assign("http://localhost:8080/movie-api/manager.html");
            }
        }
    }
    console.log("I got here.");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urelencoded");
    xhr.send(param);
}

let WelcomeElement = document.getElementById("Welcome");

function returnUser(user){
    WelcomeElement.innerHTML(`Welcome, ${user.firstName} ${user.lastName}`);
}

function Logout(){
    sessionStorage.clear();
    window.location.assign("http://localhost:8080/movie-api");
}

function Signup(){
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    let firstName = document.getElementById("firstName");
    let lastName = document.getElementById("lastName");
    var param = "username="+username+"password="+password+"firstName="+firstName+"lastName="+lastName;
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', "http://localhost:8080/movie-api/signup", true);
    xhr.setRequestHeader("Content-type", "application-x-www-form-urlencoded");
    xhr.send(encodeURI(param));
    window.location.assign("http://localhost:8080/movie-api");
}