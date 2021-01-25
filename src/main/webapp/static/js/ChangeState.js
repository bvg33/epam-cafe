const currentStates=document.getElementsByClassName('current-state');
const allStates=document.getElementsByClassName('all-states');
const allEngStates=document.getElementsByClassName('all-eng-states');
const nextButtons=document.getElementsByClassName('next-state-button');
const prevButtons=document.getElementsByClassName('prev-state-button');
const label=document.getElementsByClassName('label');
const forms=document.getElementsByClassName('form');
const applyButtons=document.getElementsByClassName('apply-button');
let position=0;
for(let i=0;i<currentStates.length;i++) {
    nextButtons[i].onclick = function () {
        getPosition(label[i].innerHTML);
        if(position+1>=allStates.length){
            position=0;
        }else{
            position++;
        }
        label[i].textContent=allStates[position].getAttribute('value');
    }
    prevButtons[i].onclick=function (){
        getPosition(label[i].innerHTML);
        if(position-1<0){
            position=allStates.length-1;
        }else{
            position--;
        }
        label[i].textContent=allStates[position].getAttribute('value');;
    }
    applyButtons[i].onclick=function () {
        let input=document.createElement('input');
        input.type='hidden';
        input.name='state';
        input.value=allEngStates[position].getAttribute('value');
        forms[i].appendChild(input);
    }
}

function getPosition(currentState){
    for (let j = 0; j < allStates.length; j++) {
        if (allStates[j].getAttribute('value')==currentState) {
            position = j;
            break;
        }
    }
}
