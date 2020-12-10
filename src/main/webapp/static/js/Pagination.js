const names = document.getElementsByClassName('allUsersNames');
const surnames = document.getElementsByClassName('allUsersSurnames');
const ages = document.getElementsByClassName('allUsersAges');
let table=document.querySelector('#table');
let pagination=document.querySelector('#pagination');
let notesOnPage=6;
let items=[];
let countOfItems=Math.ceil(names.length/notesOnPage);
for(let i=0;i<notesOnPage;i++) {
    let tr=document.createElement('tr');
    table.appendChild(tr);
    createCell(names[i].getAttribute('value'), tr);
    createCell(surnames[i].getAttribute('value'), tr);
    createCell(ages[i].getAttribute('value'), tr);
}
for(let i=0;i<countOfItems;i++){
    let li=document.createElement('li');
    let number=+i+1;
    li.innerHTML=number;
    pagination.appendChild(li);
    items.push(li);
}
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
        for(let i=start;i<end;i++){
            let tr=document.createElement('tr');
            table.appendChild(tr);
            createCell(names[i].getAttribute('value'),tr);
            createCell(surnames[i].getAttribute('value'),tr);
            createCell(ages[i].getAttribute('value'),tr);
        }
    });
}
function createCell(text,tr){
    let td=document.createElement('td');
    td.innerHTML=text;
    tr.appendChild(td);
}
