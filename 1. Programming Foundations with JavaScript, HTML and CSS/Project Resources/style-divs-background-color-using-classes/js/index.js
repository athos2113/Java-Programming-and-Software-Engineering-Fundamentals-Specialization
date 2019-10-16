function changeColor(){
  var ddiv1 = document.getElementById("div1");
  
  var ddiv2 = document.getElementById("div2");
  
  ddiv1.className = "redback";
  ddiv2.className = "yellowback";
}

function changeText(){
  var ddiv1 = document.getElementById("div1");
  var ddiv2 = document.getElementById("div2");
  
  ddiv1.innerHTML = "Assalamalekum User";
  ddiv2.innerHTML = "Khudahafiz User";
}