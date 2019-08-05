function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    var param = "username=" + username + "&password=" + password;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "http://localhost:8080/movie-api/login", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 202) {
            var JSONObject = xhr.responseText;
            if (JSONObject == "false") {
                window.location.assign("http://localhost:8080/movie-api");
            }
            if (JSONObject == "employee") {
                localStorage.setItem("username", username);
                window.location.assign("http://localhost:8080/movie-api/employee.html");
            }
            if (JSONObject == "manager" || JSONObject == "admin") {
                localStorage.setItem("username", username);
                window.location.assign("http://localhost:8080/movie-api/manager.html");
            }
        }
    }
    xhr.setRequestHeader("Content-type", "application/x-www-form-urelencoded");
    xhr.send(param);
}

let user = [];
let WelcomeElement = document.querySelector('#WelcomeM');

function updateWelcomeElement() {
    WelcomeElement.innerHTML = `Welcome, ${user.firstName} ${user.lastName}`;
}   

function ElementWelcome(){
    updateWelcomeElement();
}

function Logout() {
    sessionStorage.clear();
    window.location.assign("http://localhost:8080/movie-api");
}

function Signup() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    var param = "username=" + username + "password=" + password + "firstName=" + firstName + "lastName=" + lastName;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "http://localhost:8080/movie-api/signup", true);
    xhr.setRequestHeader("Content-type", "application-x-www-form-urlencoded");
    xhr.send(param);
}

function Manager(){
    window.location.assign("http://localhost:8080/movie-api/manager.html")
}