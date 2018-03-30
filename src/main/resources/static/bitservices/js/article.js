var voteType = -1;
var alreadyVoted = false;

function showRecaptcha(vtype) {
    if (!alreadyVoted){
        document.getElementById("grecaptcha").classList.add("recaptcha-visible");
        document.getElementById("grecaptcha").classList.remove("recaptcha");
        voteType = vtype;
    }
};

function cancelSubmit(){
    document.getElementById("grecaptcha").classList.add("recaptcha");
    document.getElementById("grecaptcha").classList.remove("recaptcha-visible");
    document.getElementById("voteprogress").classList.add("visible");
    document.getElementById("voteprogress").classList.remove("invisible");
    return false;
}

function sendVote(){
    var xhr = new XMLHttpRequest();
    var url = "http://"+window.location.href.split("/")[2]+"/api/registerVote";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 && xhr.status === 200){
            var response = JSON.parse(xhr.responseText);
            document.getElementById("voteprogress").classList.add("invisible");
            document.getElementById("voteprogress").classList.remove("visible");
            alreadyVoted = true;
            document.getElementById("amVotesUp").innerHTML = response.votesUp;
            document.getElementById("amVotesDown").innerHTML = response.votesDown;
        }
    }
    var up = 0;
    var down = 0;
    if (voteType === 1){
        up = 1;
    }
    if (voteType === 2){
        down = 1;
    }
    var data = JSON.stringify({"votesUp" : up, "votesDown": down, "nid": nid});
    xhr.send(data);
}