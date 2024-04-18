import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  //Background and DvD Image Variables
  PImage imgDvD;
  PImage imgSun;

  //Speed and Position Variables
  float fltSunX = 0;
  float fltSunY = 0;
  float fltCircleX = random(0, 350);
  float fltCircleY = random(0, 350);
  float fltDvDX = random(0, 400);
  float fltDvDY = random(0, 400);
  float fltXSpeed1 = random(1, 5);
  float fltYSpeed1 = random(1, 5);
  float fltXSpeed2 = random(3, 6);
  float fltYSpeed2 = random(3, 6);

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0, 0, 0);
    // load DvD and Background
    imgDvD = loadImage("maxresdefault.png");
    imgSun = loadImage("Sun.png");
    // resize DvD and Background
    imgDvD.resize(50, 50);
    imgSun.resize(400, 400);
  }

  public void draw() {
    
    //Sun background
    image(imgSun, fltSunX, fltSunY);
    //Draws the Circle
    ellipse(fltCircleX, fltCircleY, 50, 50);
    //Draws the DvD
    image(imgDvD, fltDvDX, fltDvDY);
    //Moves the DvD
    fltDvDX += fltXSpeed1;
    fltDvDY += fltYSpeed1;
    //Moves the Circle
    fltCircleX += fltXSpeed2;
    fltCircleY += fltYSpeed2;
    //DvD Collision
    if (fltDvDX > width - imgDvD.width || fltDvDX < 0) {
      fltXSpeed1 *= -1;
    } 

    if (fltDvDY > height - imgDvD.height || fltDvDY < 0) {
      fltYSpeed1 *= -1;
    }

    //Circle Collision
    if (fltCircleX > width - 25 || fltCircleX < 25) {
      fltXSpeed2 *= -1;
    }

    if (fltCircleY > height - 25 || fltCircleY < 25) { 
      fltYSpeed2 *= -1;
    }

    }
  }
