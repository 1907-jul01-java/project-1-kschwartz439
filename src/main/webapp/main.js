function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    sessionStorage.setItem("username", username);
    var param = "username=" + username + "&password=" + password;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "http://localhost:8080/movie-api/login", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 202) {
            sessionStorage.setItem("username", username);
            var JSONObject = xhr.responseText;
            if (JSONObject == "false") {
                sessionStorage.clear();
                window.location.assign("http://localhost:8080/movie-api");
            }
            if (JSONObject == "employee") {
                window.location.assign("http://localhost:8080/movie-api/employee.html");
            }
            if (JSONObject == "manager" || JSONObject == "admin") {
                window.location.assign("http://localhost:8080/movie-api/manager.html");
            }
        }
    }
    xhr.setRequestHeader("Content-type", "application/x-www-form-urelencoded");
    xhr.send(param);
}

let user = [];
let RequestElement = document.querySelector('#WelcomeM')

function updateWelcomeElement() {
    WelcomeElement.innerHTML = `Welcome, ${user.firstName} ${user.lastName}`;
}

function ElementWelcome() {
    updateWelcomeElement();
}

function returnUser() {
    let xhr = XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/movie-api/mrequest', true);
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
    if (xhr.readyState == 4 && xhr.status == 202) {
        window.location.assign("http://localhost:8080/movie-api/signup1.html");
    }
    xhr.setRequestHeader("Content-type", "application-x-www-form-urlencoded");
    xhr.send(param);
}

function Manager() {
    window.location.assign("http://localhost:8080/movie-api/manager.html")
}

function getUsername(){
    let xhr = new XMLHttpRequest();
    xhr.open('GET', "http://localhost:8080/movie-api/user", true);
    if (xhr.readyState==4&&xhr.status==202){
        username=xhr.responseText;
    }
    xhr.onload = function(){
        updateRequestElement();
    }
    xhr.send();
}

let requests = [];

function getRequests(){
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/movie-api/mrequest', true);
    xhr.onload = function(){
        requests = JSON.parse(xhr.responseText);
        updateRequestElement();
    }
    xhr.send(param);
}

function updateRequestElement(){
    RequestElement.innerHTML = ShowListRequests();
}
