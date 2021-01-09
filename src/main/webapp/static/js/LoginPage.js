const EYEBUTTON = document.getElementsByClassName('eye-button')[0];
const FIELD=document.getElementsByClassName('input-field')[1];
const loginButton=document.getElementsByClassName('button-login')[0];
clicks=0;
EYEBUTTON.onclick=function (){
    clicks++;
    if(clicks%2==1) {
        FIELD.setAttribute("type", "text");
    }else{
        FIELD.setAttribute("type", "password");
    }
}
loginButton.onclick=function () {
    sessionStorage.setItem("BTN_0Color", "#E76F00");
    sessionStorage.setItem("BTN_1Color", "#316dba");
    sessionStorage.setItem("BTN_2Color", "#316dba");
    sessionStorage.setItem("BTN_3Color", "#316dba");
}