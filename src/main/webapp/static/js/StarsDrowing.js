const counts = document.getElementsByClassName('order-rating');
const tds = document.getElementsByClassName('order-rating-td');

for(let i=0;i<tds.length;i++){
  if(counts[i].getAttribute('value')!=='0'){
    let label=document.createElement('label');
    for(let j=0;j<counts[i].getAttribute('value');j++){
      label.innerHTML+='🌟';
    }
    label.style.fontSize='17px';
    tds[i].appendChild(label);
  }
}

