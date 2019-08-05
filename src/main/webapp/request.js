function Submit() {
    let requestName = document.getElementById("requestName").value;
    let requestType = document.getElementById("requestType").value;
    let cost = document.getElementById("cost").value;
    let requestDescription = document.getElementById("requestDescription").value;
    let username = sessionStorage.getItem("username");
    var param = "requestName=" + requestName + "requestType=" + requestType + "cost=" + cost + "requestDescription=" + requestDescription+"username="+username;
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "http://localhost:8080/movie-api/submit", true);
    xhr.setRequestHeader("Content-Type", "application-x-www-form-urlencoded");
    xhr.send(param);
    window.location.assign("http://localhost:8080/movie-api/request.html")
}

let requests = [];
let RequestElement = document.querySelector('#WelcomeM')

function ShowRequests() {
    return `<tr>
                <td>${requests.requestName}</td>
                <td>${requests.requestType}</td>
                <td>${requests.cost}</td>
                <td>${requests.requestDescription}</td>
            </tr>`
}

function ShowListRequests() {
    return `<table>
            <tr>
                <th>Request Name:</th>
                <th>Request Type:</th>
                <th>Cost:</th>
                <th>Request Description:</th>
            </tr>
            ${requests.map(ShowRequests).join('')}
        </table>`;
}

function ShowRequestsManager() {

}

function UpdateApproved() {

}

function getRequests(){
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/movie-api/mrequest', true);
    xhr.onload = function(){
        requests = JSON.parse(xhr.responseText);
        updateRequestElement();
    }
    xhr.send(param);
}

window.onload = getRequestsEM();

function getRequestsEM(){
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/movie-api/requests', true);
    let username = sessionStorage.getItem("username");
    let param = "username="+username;
    xhr.onload = function(){
        requests = JSON.parse(xhr.responseText);
        updateRequestElementEM();
    }
    xhr.send(param);
}

function updateRequestElementEM(){
    RequestElement.innerHTML = ShowListRequests();
}

function updateRequestElement(){
    RequestElement.innerHTML = ShowListRequests();
}