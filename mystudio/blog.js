function showNhide(){
let imo = document.querySelector(".imo");
let showImg = document.querySelector("#comTalk");
let showImg2 = document.querySelector("#comTalk2");
let box = document.querySelector("search")

 document.querySelector(".imo").addEventListener('click',()=>{
    document.getElementById('comTalk').style.display='block';
  })

  document.querySelector('#comTalk').addEventListener('click',()=>{
    document.getElementById('comTalk').style.display ='none';
  })

  document.querySelector("#comTalk").addEventListener('click',()=>{
    document.getElementById("comTalk2").style.display="block";
    
  })
  document.querySelector("#comTalk2").addEventListener('click',()=>{
    document.getElementById("comTalk2").style.display="none";
    document.getElementById('serach').style.display='block';

    
  })
}
showNhide();

