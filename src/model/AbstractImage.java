package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public abstract class AbstractImage implements ImageInterface {

  private Pixel[][] image;
  private int width;
  private int height;

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

    for (int x = 0; x < img.getWidth(); x++) {
      for (int y = 0; y < img.getHeight(); y++) {
        Color color = new Color(img.getRGB(x, y));
        newImage[x][y] = new Pixel(color.getRed(),color.getGreen(), color.getBlue());
      }
    }
    return newImage;
  }





}