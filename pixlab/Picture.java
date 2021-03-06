import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void zeroRed(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray)
          pixelObj.setRed(0);
        }
    }
    
  public void zeroGreen(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray)
          pixelObj.setGreen(0);
        }
    }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < width / 2 ; row++)
    {
      for (int col = 0; col < pixels.length; col++)
      {
        leftPixel = pixels[col][row];
        rightPixel = pixels[col][width - 1 - row];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
}

public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int width = pixels.length;
    for (int row = 0; (row) < width/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[width-row-1][col];
        botPixel.setColor(topPixel.getColor());
      }
    } 
}

public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    int width = pixels.length;
    for (int row = 0; (row) < width/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        botPixel = pixels[row][col];
        topPixel = pixels[width-row-1][col];
        botPixel.setColor(topPixel.getColor());
      }
    } 
}

public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel topPixel = null;
    int width = pixels.length;
    int height = pixels[0].length;
    
    if(height<width)
    width=height;
    
    for (int row = 0; row < width; row++)
    {
      for (int col = 0; col < width; col++)
      {
        if(row==col)
        break;
        leftPixel = pixels[row][col];
        topPixel = pixels[col][row];
        topPixel.setColor(leftPixel.getColor());
      }
    } 
}
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        
      }
    }
    System.out.println(count);
  }
    
  public void mirrorArms()
  {
    int mirrorPoint = 170;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    
    // loop through the rows
    for (int row = 157; row < 191; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 103; col < 170; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row+80]                       
                         [col-7];
        rightPixel.setColor(leftPixel.getColor());
        
      }
    }
    for (int row = 171; row < 197; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 238; col < 295; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row+80]                       
                         [col+6 ];
        rightPixel.setColor(leftPixel.getColor());
        
      }
    }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 170;
    Pixel leftPixel = null;
    Pixel rightPixel = null;

    Pixel[][] pixels = this.getPixels2D();
    
    
    // loop through the rows
    for (int row = 234; row < 321; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 238; col < 345; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row+30]                       
                         [col+130 ];
          if((leftPixel.getRed()>15 && leftPixel.getRed()<150)&&(leftPixel.getGreen()>15&&leftPixel.getGreen()<150)&&(leftPixel.getBlue()>20
          &&leftPixel.getGreen()<150)){
              if((leftPixel.getRed()>100 && leftPixel.getRed()<135)&&(leftPixel.getGreen()>110&&leftPixel.getGreen()<150)&&(leftPixel.getBlue()>125
          &&leftPixel.getGreen()<150)){
          
        }
            else{
                rightPixel.setColor(leftPixel.getColor());
            }
        }
      }
    }
    
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
   public void copy(Picture fromPic, 
                 int startRow, int startCol,
                 int fSR,      int fSC,
                 int fER,      int fEC)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fSR, toRow = startRow; 
         fromRow < fER &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = fSC, toCol = startCol; 
           fromCol < fEC &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
    Picture snowman = new Picture("640x480.jpg");
    Picture snowman1 = new Picture("flower1.jpg");
    Picture snowman2 = new Picture("flower2.jpg");
    Picture snowman3 = new Picture("robot.jpg");
    this.copy(snowman1,0,0,0,0,100,100);
    snowman2.mirrorVertical();
    this.mirrorDiagonal();
    snowman3.zeroBlue();
    
    this.copy(snowman2,100,100,0,0,100,100);
    this.copy(snowman3,200,200,0,0,65,40);
    this.mirrorVertical();
    
    
  }
  
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else{
          leftPixel.setColor(Color.WHITE);
        }
      }
    }
    for (int row = 0; row < pixels[0].length-1; row++)
    {
      for (int col = 0; 
           col < pixels.length-1; col++)
      {
        leftPixel = pixels[col][row];
        rightPixel = pixels[col+1][row];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else{
          leftPixel.setColor(Color.WHITE);
        }
      }
    }
  }
  
  public void keepOnlyBlue(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray)
          pixelObj.setGreen(0);
        }
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray)
          pixelObj.setRed(0);
        }
    }
  
  public void negate(){
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray)
          pixelObj.setGreen(255-pixelObj.getGreen());
        }
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray)
          pixelObj.setRed(255-pixelObj.getRed());
        }
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray)
          pixelObj.setBlue(255-pixelObj.getBlue());
        }
    }
  public void grayscale(){
      Pixel[][] pixels = this.getPixels2D();
      
      
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray){
          int avg = (pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
          pixelObj.setRed(avg);
          pixelObj.setGreen(avg);
          pixelObj.setBlue(avg);
        }
        }
    }
    
  public void fixUnderwater(){
      Pixel[][] pixels = this.getPixels2D();
      
      for(Pixel[] rowArray:pixels){
          for (Pixel pixelObj:rowArray){
          if((pixelObj.getRed()>10 && pixelObj.getRed()<26)&&(pixelObj.getGreen()>150&&pixelObj.getGreen()<175)&&(pixelObj.getBlue()>154&&pixelObj.getGreen()<185)){
          pixelObj.setRed(108);
          pixelObj.setGreen(162);
          pixelObj.setBlue(255);
          
        }
        }
        }
      
    }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    //beach.zeroBlue();
    //beach.zeroRed();
    //beach.zeroGreen();
    //beach.keepOnlyBlue();
    //beach.negate();
    //beach.grayscale();
    
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
