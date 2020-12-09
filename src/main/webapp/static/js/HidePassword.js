const EYEBUTTON = document.getElementsByClassName('eye-button')[0];
const FIELD=document.getElementsByClassName('input-field')[1];
clicks=0;
EYEBUTTON.onclick=function (){
    clicks++;
    if(clicks%2==1) {
        FIELD.setAttribute("type", "text");
    }else{
        FIELD.setAttribute("type", "password");
    }
}