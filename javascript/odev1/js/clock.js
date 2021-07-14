const askName = () => {
    let userName = prompt("Adınız nedir: ")
    let myName = document.querySelector("#myName");
    myName.innerHTML = userName;
}

showTime = () => {
    var date = new Date();
    var h = date.getHours().toString().padStart(2, '0');
    var m = date.getMinutes().toString().padStart(2, '0');
    var s = date.getSeconds().toString().padStart(2, '0');
    var session = date.toLocaleString(window.navigator.language, { weekday: 'long' });;

    var time = h + ":" + m + ":" + s + " " + session;

    document.getElementById("myClock").innerText = time;
    document.getElementById("myClock").textContent = time;
}

const timeIntervalId = setInterval(showTime, 1000);
// clearInterval(timeIntervalId);

askName();