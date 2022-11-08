package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the PPM image.
 */
public class PPMImage extends AbstractImage {
  private Pixel[][] image;
  private int width;
  private int height;
  private int maxValue;


  /**
   * Constructor for the PPM Image.
   * @param fileAddress String: file address used in readPPM
   * @throws FileNotFoundException thrown in the readPPM if the file is not found in directory
   */
  public PPMImage(String fileAddress) throws IOException {
    super(fileAddress);
    this.maxValue = this.maxImageRGBValue();
  }

  /**
   * PPMImage constructor that takes in the 2D array of pixels.
   * @param pixels : the 2D array representing the image
   */
  public PPMImage(Pixel[][] pixels) {
    super(pixels);
    this.maxValue = this.maxImageRGBValue();
  }

  /**
   * Reads the filename and converts to 2D array of pixels.
   * @param filename : the String representing the filename
   * @return Pixel[][]: a 2D array of Pixels (which represent the RGB values)
   * @throws FileNotFoundException : if the file isn't found in the directory
   */


  /**
   * Finds the maximum rgb value in the 2D array
   * @return Integer, returns the maximum RGB value
   */
  private int maxImageRGBValue() {
    int max = 0;
    for (int h = 0; h <this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        max = Math.max(this.image[w][h].maxRGBValue(), max);
      }
    }
    return max;
  }

  public StringBuilder convertToString() {
    StringBuilder builder = new StringBuilder();

    builder.append("P3\n");
    builder.append(this.height + " " + this.width + "\n");
    builder.append(this.maxValue + "\n");

    for(int x = 0; x < this.width; x++) {
      for(int y = 0; y < this.height; y++) {
        builder.append(this.image[x][y].getPixel()[0] + "\n"
                + this.image[x][y].getPixel()[1] + "\n"
                + this.image[x][y].getPixel()[2] + "\n");
      }
    }
    return builder;
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
