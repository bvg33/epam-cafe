const names = document.getElementsByClassName('allNames');
const price = document.getElementsByClassName('allPrice');
const descriptions = document.getElementsByClassName('allDescriptions');
const photos = document.getElementsByClassName('allPhotos');
let table=document.querySelector('#table');
let pagination=document.querySelector('#pagination');
let notesOnPage=3;
let items=[];
let countOfItems=Math.ceil(names.length/notesOnPage);
let buttonText=document.getElementsByClassName('addToOrderBtnText')[0].getAttribute('value');
let thText=[
    {name:document.getElementsByClassName('name')[0].getAttribute('value')},
    {name:document.getElementsByClassName('price')[0].getAttribute('value')},
    {name:document.getElementsByClassName('description')[0].getAttribute('value')},
    {name:document.getElementsByClassName('photo')[0].getAttribute('value')},
    {name:document.getElementsByClassName('addToOrderBtnText')[0].getAttribute('value')}
];
createTh();
for(let i=0;i<notesOnPage;i++) {
    let tr=document.createElement('tr');
    table.appendChild(tr);
    createCell(names[i].getAttribute('value'), tr);
    createCell(price[i].getAttribute('value'), tr);
    createCell(descriptions[i].getAttribute('value'), tr);
    createPhoto(photos[i].getAttribute('value'),tr);
    createButton(tr,buttonText);
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
            createCell(descriptions[i].getAttribute('value'), tr);
            createPhoto(photos[i].getAttribute('value'),tr);
            createButton(tr,buttonText);
        }
    });
}
function createCell(text,tr){
    let td=document.createElement('td');
    td.classList.add('text')
    td.innerHTML=text;
    tr.appendChild(td);
}
function createButton(tr,buttonText){
    let td=document.createElement('td');
    let button=document.createElement('button');
    button.textContent=buttonText;
    button.style.background="#02d5f8";
    button.style.height='35px';
    td.appendChild(button);
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
    for(let i=0;i<5;i++) {
        let th = document.createElement('th');
        th.innerHTML = thText[i].name;
        tr.appendChild(th);
    }
    table.appendChild(tr);
}
