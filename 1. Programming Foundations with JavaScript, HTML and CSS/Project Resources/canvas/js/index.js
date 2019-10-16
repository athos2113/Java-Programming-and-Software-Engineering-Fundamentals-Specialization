function doRed(){
  var canvas = document.getElementById("div1");
  canvas.style.backgroundColor = "red";
  
  var context = canvas.getContext("2d");
  context.fillStyle = "black";
  context.fillRect(10,10,40,40);
  context.fillRect(80,10,40,40);
}

function doGreen(){
  var canvas = document.getElementById("div2");
  canvas.style.backgroundColor = "Green";
 
}