const BTN_2 = document.getElementsByClassName('sideButton')[2];
const BTN_1 = document.getElementsByClassName('sideButton')[1];
const BTN_0 = document.getElementsByClassName('sideButton')[0];
if (sessionStorage.getItem("BTN_0Color") == null) {
    sessionStorage.setItem("BTN_0Color", "#E76F00");
}
BTN_0.onclick = function () {
    BTN_1.style.background = "#316dba";
    BTN_2.style.background = "#316dba";
    BTN_0.style.background = "#E76F00";
    sessionStorage.setItem("BTN_0Color", "#E76F00");
    sessionStorage.setItem("BTN_1Color", "#316dba");
    sessionStorage.setItem("BTN_2Color", "#316dba");
}
BTN_1.onclick = function () {
    BTN_0.style.background = "#316dba";
    BTN_2.style.background = "#316dba"
    BTN_1.style.background = "#E76F00";
    sessionStorage.setItem("BTN_1Color", "#E76F00");
    sessionStorage.setItem("BTN_0Color", "#316dba");
    sessionStorage.setItem("BTN_2Color", "#316dba");
}
BTN_2.onclick = function () {
    BTN_1.style.background = "#316dba";
    BTN_0.style.background = "#316dba";
    BTN_2.style.background = "#E76F00";
    sessionStorage.setItem("BTN_2Color", "#E76F00");
    sessionStorage.setItem("BTN_1Color", "#316dba");
    sessionStorage.setItem("BTN_0Color", "#316dba");
}
BTN_0.style.background = sessionStorage.getItem("BTN_0Color");
BTN_1.style.background = sessionStorage.getItem("BTN_1Color");
BTN_2.style.background = sessionStorage.getItem("BTN_2Color");