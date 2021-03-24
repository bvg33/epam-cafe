const plusButtons = document.getElementsByClassName('plus-button')
const minusButtons = document.getElementsByClassName('minus-button')
const applyButtons =  document.getElementsByClassName('apply-button')
labels=document.getElementsByClassName('loyality-points')
form =document.getElementsByClassName('change-loyality')
for(let i=0;i<applyButtons.length;i++) {
    plusButtons[i].onclick = function () {
        labels[i].innerHTML = parseInt(labels[i].innerHTML, 10) + 1;
    }
    minusButtons[i].onclick = function () {
        labels[i].innerHTML = parseInt(labels[i].innerHTML, 10) - 1;
    }
    applyButtons[i].onclick = function () {
        let input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'loyality';
        input.value = labels[i].innerHTML;
        form[i].appendChild(input);
    }
}