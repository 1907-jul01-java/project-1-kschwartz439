function Submit(){
    let requestName = document.getElementById("requestName");
    let requestType = document.getElementById("requestType");
    let cost = document.getElementById("cost");
    let requestDescription = document.getElementById("requestDescription");
    let image = document.getElementById("image");
    let approved = "pending";
    var param = "requestName="+requestName+"requestType="+requestType+"cost="+cost+"requestDescription="+requestDescription+"image="+image+"approved="+approved;
    let xhr = new XMLHttpRequest();
    xhr.open('PUT', "http://localhost:8080/movie-api/request", true);
    xhr.setRequestHeader("Content-Type", "application-x-www-form-urlencoded");
    xhr.send(encodeURI(param));
    window.location.assign("http://localhost:8080/movie-api/request.html")
}