const names = document.getElementsByClassName('allNames');
const price = document.getElementsByClassName('allPrice');
const photos = document.getElementsByClassName('allPhotos');
const ids = document.getElementsByClassName('allIds');
let table=document.querySelector('#table');
let pagination=document.querySelector('#pagination');
let alertMessage=document.getElementsByClassName('alertMessage')[0].getAttribute('value');
let notesOnPage=4;
let items=[];
let countOfItems=Math.ceil(names.length/notesOnPage);
let buttonText=document.getElementsByClassName('btnText')[0].getAttribute('value');
let thText=[
    {name:document.getElementsByClassName('name')[0].getAttribute('value')},
    {name:document.getElementsByClassName('price')[0].getAttribute('value')},
    {name:document.getElementsByClassName('photo')[0].getAttribute('value')},
    {name:document.getElementsByClassName('btnText')[0].getAttribute('value')}
];
let command=document.getElementsByClassName('command')[0].getAttribute('value');
createTh();
for(let i=0;i<notesOnPage;i++) {
    let tr=document.createElement('tr');
    table.appendChild(tr);
    createCell(names[i].getAttribute('value'), tr);
    createCell(price[i].getAttribute('value'), tr);
    createPhoto(photos[i].getAttribute('value'),tr);
    createButton(tr,buttonText,i,alertMessage);
}
for(let i=0;i<countOfItems;i++){
    let li=document.createElement('li');
    let number=+i+1;
    li.innerHTML=number;
    pagination.appendChild(li);
    items.push(li);
}
items[0].classList.add('active');
for(let item of items){
    item.addEventListener('click',function (){
        let active=document.querySelector('#pagination li.active');
        if(active!=null) {
            active.classList.remove('active');
        }
        this.classList.add('active');
        let pageNum=+this.innerHTML;
        let start=(pageNum-1)*notesOnPage;
        let end=start+notesOnPage;
        table.innerHTML='';
        createTh();
        for(let i=start;i<end;i++){
            let tr=document.createElement('tr');
            table.appendChild(tr);
            createCell(names[i].getAttribute('value'), tr);
            createCell(price[i].getAttribute('value'), tr);
            createPhoto(photos[i].getAttribute('value'),tr);
            createButton(tr,buttonText,i,alertMessage);
        }
    });
}
function createCell(text,tr){
    let td=document.createElement('td');
    td.classList.add('text')
    td.innerHTML=text;
    tr.appendChild(td);
}
function createButton(tr,buttonText,i,alertMessage){
    let td=document.createElement('td');
    let button=document.createElement('button');
    let form=document.createElement('form');
    let inputId=document.createElement('input');
    inputId.type='hidden';
    inputId.name='dishId';
    inputId.value=ids[i].getAttribute('value');
    button.addEventListener('click',function (){
        alert(alertMessage);
    });
    form.appendChild(inputId);
    form.appendChild(button);
    button.type='submit';
    button.name='command';
    button.value=command;
    button.textContent=buttonText;
    button.style.background="#02d5f8";
    button.style.height='35px';
    td.appendChild(form);
    tr.appendChild(td);
}
function createPhoto(photoAddress,tr){
    let td=document.createElement('td');
    let image=document.createElement('img');
    image.src='static/images/'+photoAddress;
    image.style.width='120px';
    image.style.height='120px';
    td.appendChild(image);
    tr.appendChild(td);
}
function createTh(){
    let tr = document.createElement('tr');
    for(let i=0;i<4;i++) {
        let th = document.createElement('th');
        th.innerHTML = thText[i].name;
        tr.appendChild(th);
    }
    table.appendChild(tr);
}
