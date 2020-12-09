const LOGOUT=document.getElementsByClassName('logout')[0];
const PROFILE=document.getElementsByClassName('profile')[0];
LOGOUT.onclick=function (){
    sessionStorage.removeItem("BTN_2Color");
    sessionStorage.removeItem("BTN_1Color");
    sessionStorage.removeItem("BTN_0Color");

}
PROFILE.onclick=function (){
    BTN_1.onclick();
}