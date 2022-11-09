package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.CodeSigner;
import java.util.Scanner;

import javax.imageio.ImageIO;

public abstract class AbstractImage implements ImageInterface {

  protected Pixel[][] image;
  protected int width;
  protected int height;

  public AbstractImage(String fileAddress) throws IOException {
    this.image = readFile(fileAddress);
    this.width = image.length;
    this.height = image[0].length;
  }

  public AbstractImage(Pixel[][] pixels) {
    this.image = pixels;
    this.width = this.image.length;
    this.height = this.image[0].length;
  }

  public Pixel[][] readFile(String fileAddress) throws IOException {

    String fileFormat = getFileFormat(fileAddress);

    if(fileFormat.equals("ppm")) {
      return readPPM(fileAddress);
    } else {
      return readImage(fileAddress);
    }
  }



  public void saveImage(String pathname) {
    String fileFormat = getFileFormat(pathname);

    if (fileFormat.equals("ppm")) {
      PPMImage ppmImage = new PPMImage(this.image);
      ppmImage.saveImage(pathname);
    } else {
      GenericImage genericImage = new GenericImage(this.image);
      genericImage.saveImage(pathname);
    }
  }

  // used to read the PPM images
  public Pixel[][] readPPM(String filename) throws FileNotFoundException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e) {
      throw new FileNotFoundException();
    }

    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    Pixel[][] pixels = new Pixel[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        pixels[i][j] = new Pixel(sc.nextInt(),sc.nextInt(), sc.nextInt());
      }
    }

    return pixels;
  }

  // used to get the file format
  public String getFileFormat(String fileAddress) {
    int index = 0;
    for(int i = fileAddress.length() - 1; i >= 0; i--) {
      if(String.valueOf(fileAddress.charAt(i)).equals(".")) {
        index = i;
        break;
      }
    }
    return fileAddress.substring(index + 1);
  }


 // reading any generic images
  public Pixel[][] readImage(String filename) throws IOException {

    BufferedImage img =  ImageIO.read(new File(filename));

    Pixel[][] newImage = new Pixel[img.getWidth()][img.getHeight()];

    System.out.println(img.getWidth());
    System.out.println(img.getHeight());

    for (int x = 0; x < img.getWidth(); x++) {
      for (int y = 0; y < img.getHeight(); y++) {
        Color color = new Color(img.getRGB(x, y));
        newImage[x][y] = new Pixel(color.getRed(),color.getGreen(), color.getBlue());
      }
    }
    return newImage;
  }

  public Pixel[][] flipHorizontally() {
    Pixel[][] newImage = new Pixel[this.width][this.height];

    for (int y = 0; y < this.height; y++) {
      for (int x = 0; x < this.width; x++) {
        newImage[x][y] = image[x][image[x].length - y - 1];
      }
    }
    return newImage;

  }

  public Pixel[][] flipVertically() {
    Pixel[][] newImage = new Pixel[this.width][this.height];

    for (int y = 0; y < this.height; y++) {
      for (int x = 0; x < this.width; x++) {
        newImage[x][y] = image[image.length - x - 1][y];
      }
    }
    return newImage;
  }

  public Pixel[][] turnRedGreyScale() {
    Pixel[][] newImage = new Pixel[this.width][this.height];
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        newImage[w][h] = this.image[w][h].redComponent();
      }
    }
    return newImage;
  }

  public Pixel[][] turnGreenGreyScale() {
    Pixel[][] newImage = new Pixel[this.width][this.height];
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        newImage[w][h] = this.image[w][h].greenComponent();
      }
    }
    return newImage;
  }

  public Pixel[][] turnBlueGreyScale() {
    Pixel[][] newImage = new Pixel[this.width][this.height];
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        newImage[w][h] = this.image[w][h].blueComponent();
      }
    }
    return newImage;
  }

  public Pixel[][] turnValueGreyScale() {
    Pixel[][] newImage = new Pixel[this.width][this.height];
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        newImage[w][h] = this.image[w][h].value();
      }
    }
    return newImage;
  }

  public Pixel[][] turnLumaGreyScale() {
    Pixel[][] newImage = new Pixel[this.width][this.height];
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        newImage[w][h] = this.image[w][h].luma();
      }
    }
    return newImage;
  }

  public Pixel[][] turnIntensityGreyScale() {
    Pixel[][] newImage = new Pixel[this.width][this.height];
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        newImage[w][h] = this.image[w][h].intensity();
      }
    }
    return newImage;
  }

  public Pixel[][] changeBrightness(int value) {
    Pixel[][] newImage = new Pixel[this.width][this.height];
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        newImage[w][h] = this.image[w][h].brightenPixel(value);
      }
    }
    return newImage;
  }


}