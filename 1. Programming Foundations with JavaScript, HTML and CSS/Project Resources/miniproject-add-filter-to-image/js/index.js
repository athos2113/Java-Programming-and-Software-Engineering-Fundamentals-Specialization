var originalImage = null;
var grayImage = null;
var sepiaImage = null;
var redImage = null;
var rainbowImage = null;
var canvas = document.getElementById("canvas1");

function loadImage() {
  var file = document.getElementById("finput");
  originalImage = new SimpleImage(file);
  grayImage = new SimpleImage(file);
  redImage = new SimpleImage(file);
  sepiaImage = new SimpleImage(file);
  rainbowImage = new SimpleImage(file);
  originalImage.drawTo(canvas);
}

function doGray() {
  if (imageIsLoaded(grayImage)) {
    filterGray();
    grayImage.drawTo(canvas);
  }
}

function filterGray() {
  for (var pixel of grayImage.values()) {
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    pixel.setRed(avg);
    pixel.setGreen(avg);
    pixel.setBlue(avg);
  }
}

function doRed() {
  if (imageIsLoaded(redImage)) {
    filterRed();
    redImage.drawTo(canvas);
  }
}

function filterRed() {
  for (var pixel of redImage.values()) {
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    if (avg < 128) {
      pixel.setRed(2 * avg);
      pixel.setGreen(0);
      pixel.setBlue(0);
    } else {
      pixel.setRed(255);
      pixel.setGreen(2 * avg - 255);
      pixel.setBlue(2 * avg - 255);
    }
  }
}

function doReset() {
  if (imageIsLoaded(originalImage)) {
    originalImage.drawTo(canvas);
    grayImage = new SimpleImage(originalImage);
    redImage = new SimpleImage(originalImage);
  }
}

function imageIsLoaded(img) {
  if (img == null || !img.complete()) {
    alert("Image not loaded");
    return false;
  } else {
    return true;
  }
}

function doSepia() {
  if (imageIsLoaded(sepiaImage)) {
    filterSepia();
    sepiaImage.drawTo(canvas);
  }
}

function filterSepia(){
  for (var pixel of sepiaImage.values()) {
    //var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    
    //  Red should be converted to (R*.299)+(G*.587)+(B*.114)


//  Green should be converted to (R*.299)+(G*.587)+(B*.114)


//  Blue should be converted to (R*.299)+(G*.587)+(B*.114)
    
 pixel.setRed(pixel.getRed() * 0.299 +            pixel.getGreen() * 0.587 + pixel.getBlue() * 0.114);
    
    
    pixel.setGreen(pixel.getRed() * 0.299 +            pixel.getGreen() * 0.587 + pixel.getBlue() * 0.114);
    pixel.setBlue(pixel.getRed() * 0.299 +            pixel.getGreen() * 0.587 + pixel.getBlue() * 0.114);
  }
  
}

function doRainbow() {
  if (imageIsLoaded(rainbowImage)) {
    filterRainbow();
    rainbowImage.drawTo(canvas);
  }
}

function filterRainbow() {
  
  for(var pixel of rainbowImage.values()){
    
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
    
    /------------RED STRIP------------------------------/
    if(pixel.getY() <= imageRainbow.getHeight() * (1/7)){
      
      if(avg < 128){
        pixel.setRed(2 * avg);
        pixel.setGreen(0);
        pixel.setBlue(0);
      }
      else{
        pixel.setRed(255);
        pixel.setGreen((2* avg) - 255);
        pixel.setBlue((2* avg) - 255);
      }
    }
    
    /------------ORANGE STRIP------------------------------/
    if(( pixel.getY() > imageRainbow.getHeight() * (1/7)) && ( pixel.getY() <= imageRainbow.getHeight() * (2/7)) ){
    if(avg < 128){
        pixel.setRed(2 * avg);
        pixel.setGreen(0.8 * avg);
        pixel.setBlue(0);
      }
      else{
        pixel.setRed(255);
        pixel.setGreen((1.2* avg) - 51);
        pixel.setBlue((2* avg) - 255);
      }   
    }
    
   /------------YELLOW STRIP------------------------------/
    if(( pixel.getY() > imageRainbow.getHeight() * (2/7)) && ( pixel.getY() <= imageRainbow.getHeight() * (3/7)) ){
    if(avg < 128){
        pixel.setRed(2 * avg);
        pixel.setGreen(2 * avg);
        pixel.setBlue(0);
      }
      else{
        pixel.setRed(255);
        pixel.setGreen(255);
        pixel.setBlue((2* avg) - 255);
      }   
    }
    
   /------------GREEN STRIP------------------------------/
    if(( pixel.getY() > imageRainbow.getHeight() * (3/7)) && ( pixel.getY() <= imageRainbow.getHeight() * (4/7)) ){
    if(avg < 128){
        pixel.setRed(0);
        pixel.setGreen(2 * avg);
        pixel.setBlue(0);
      }
      else{
        pixel.setRed((2 * avg) - 255);
        pixel.setGreen(255);
        pixel.setBlue((2* avg) - 255);
      }   
    }
    
   /------------BLUE STRIP------------------------------/
    if(( pixel.getY() > imageRainbow.getHeight() * (4/7)) && ( pixel.getY() <= imageRainbow.getHeight() * (5/7)) ){
    if(avg < 128){
        pixel.setRed(0);
        pixel.setGreen(0);
        pixel.setBlue(2 * avg);
      }
      else{
        pixel.setRed((2 * avg) - 255);
        pixel.setGreen((2* avg) - 255);
        pixel.setBlue(255);
      }   
    }
    
  /------------INDIGO STRIP------------------------------/
    if(( pixel.getY() > imageRainbow.getHeight() * (5/7)) && ( pixel.getY() <= imageRainbow.getHeight() * (6/7)) ){
    if(avg < 128){
        pixel.setRed(0.8 * avg);
        pixel.setGreen(0);
        pixel.setBlue(2 * avg);
      }
      else{
        pixel.setRed((1.2 * avg) - 51);
        pixel.setGreen((2* avg) - 255);
        pixel.setBlue(255);
      }   
    } 
    
    
   /------------VIOLET STRIP------------------------------/
    if(( pixel.getY() > imageRainbow.getHeight() * (6/7))){
    if(avg < 128){
        pixel.setRed(1.6 * avg);
        pixel.setGreen(0);
        pixel.setBlue(1.6 * avg);
      }
      else{
        pixel.setRed((0.4 * avg) + 153);
        pixel.setGreen((2* avg) - 255);
        pixel.setBlue((0.4 * avg) + 153);
      }   
    }
    
  }
}