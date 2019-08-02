function login() {
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    var param = "username="+username+"&password="+password;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "http://localhost:8080/movie-api/login", true);
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4 && xhr.status == 200){
            var JSONObject = xhr.responseText;
            if (JSONObject == "false"){
                window.location("http://localhost:8080/movie-api");
            }
            if (JSONObject == "employee"){
                window.location("http://localhost:8080/movie-api/employee.html");
            }
            if (JSONObject == "manager" || JSONObject == "admin"){
                window.location("http://localhost:8080/movie-api/manager.html");
            }
        }
    }
    console.log("I got here.");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urelencoded");
    xhr.send(encodeURI(param));
}

let WelcomeElement = document.getElementById("Welcome");

function returnUser(user){
    WelcomeElement.innerHTML(`Welcome, ${user.firstName} ${user.lastName}`);
}

function Logout(){
    sessionStorage.clear();
    window.location.assign("http://localhost:8080/movie-api");
}