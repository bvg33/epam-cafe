const ADMIN_BTN_4 = document.getElementsByClassName('adminSideButton')[4];
const ADMIN_BTN_3 = document.getElementsByClassName('adminSideButton')[3];
const ADMIN_BTN_2 = document.getElementsByClassName('adminSideButton')[2];
const ADMIN_BTN_1 = document.getElementsByClassName('adminSideButton')[1];
const ADMIN_BTN_0 = document.getElementsByClassName('adminSideButton')[0];
ADMIN_BTN_0.onclick = function () {
    sessionStorage.setItem("ADMIN_BTN_0Color", "#E76F00");
    sessionStorage.setItem("ADMIN_BTN_1Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_2Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_3Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_4Color", "#316dba");
}
ADMIN_BTN_1.onclick = function () {
    sessionStorage.setItem("ADMIN_BTN_1Color", "#E76F00");
    sessionStorage.setItem("ADMIN_BTN_0Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_2Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_3Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_4Color", "#316dba");
}
ADMIN_BTN_2.onclick = function () {
    sessionStorage.setItem("ADMIN_BTN_2Color", "#E76F00");
    sessionStorage.setItem("ADMIN_BTN_1Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_0Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_3Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_4Color", "#316dba");

}
ADMIN_BTN_3.onclick = function () {
    sessionStorage.setItem("ADMIN_BTN_3Color", "#E76F00");
    sessionStorage.setItem("ADMIN_BTN_1Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_0Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_2Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_4Color", "#316dba");

}
ADMIN_BTN_4.onclick = function () {
    sessionStorage.setItem("ADMIN_BTN_4Color", "#E76F00");
    sessionStorage.setItem("ADMIN_BTN_1Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_0Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_2Color", "#316dba");
    sessionStorage.setItem("ADMIN_BTN_3Color", "#316dba");

}
ADMIN_BTN_0.style.background = sessionStorage.getItem("ADMIN_BTN_0Color");
ADMIN_BTN_1.style.background = sessionStorage.getItem("ADMIN_BTN_1Color");
ADMIN_BTN_2.style.background = sessionStorage.getItem("ADMIN_BTN_2Color");
ADMIN_BTN_3.style.background = sessionStorage.getItem("ADMIN_BTN_3Color");
ADMIN_BTN_4.style.background = sessionStorage.getItem("ADMIN_BTN_4Color");
