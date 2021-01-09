const LOGOUT=document.getElementsByClassName('logout')[0];
const PROFILE=document.getElementsByClassName('profile')[0];
LOGOUT.onclick=function (){
    sessionStorage.removeItem("BTN_2Color");
    sessionStorage.removeItem("BTN_1Color");
    sessionStorage.removeItem("BTN_0Color");
    sessionStorage.removeItem("BTN_3Color");

}
PROFILE.onclick=function (){
    if (PROFILE.textContent.replace(/\s/g, '')!='ADMIN') {
        BTN_1.onclick();
    }else {
        sessionStorage.removeItem("BTN_2Color");
        sessionStorage.removeItem("BTN_1Color");
        sessionStorage.removeItem("BTN_0Color");
        sessionStorage.removeItem("BTN_3Color");
        sessionStorage.setItem("ADMIN_BTN_1Color", "#316dba");
        sessionStorage.setItem("ADMIN_BTN_0Color", "#E76F00");
        sessionStorage.setItem("ADMIN_BTN_2Color", "#316dba");
        sessionStorage.setItem("ADMIN_BTN_3Color", "#316dba");
    }
}