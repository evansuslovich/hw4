
package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GenericImage implements ImageInterface {

  private Pixel[][] image;
  private int width;
  private int height;

  private int maxValue;

  public GenericImage(String fileAddress) throws IOException {
    this.image = readImage(fileAddress);
    this.width = image.length;
    this.height = image[0].length;
  }

  public Pixel[][] readImage(String filename) throws IOException{


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

  //used for testing purposes only
  public Pixel[][] getImage() {
    return image;
  }

  /**
   * Converts the image to a StringBuilder.
   *
   * @return StringBuilder: a mutable sequence of characters that represent the PPM
   */
  @Override
  public StringBuilder convertToString() {
    return null;
  }

  /**
   * Flips the image horizontally.
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] flipHorizontally() {
    return new Pixel[0][];
  }

  /**
   * Flips the image vertically.
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] flipVertically() {
    return new Pixel[0][];
  }

  /**
   * Converts grey scale using the red component.
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] turnRedGreyScale() {
    return new Pixel[0][];
  }

  /**
   * Converts grey scale using the green component.
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] turnGreenGreyScale() {
    return new Pixel[0][];
  }

  /**
   * Converts grey scale using the blue component.
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] turnBlueGreyScale() {
    return new Pixel[0][];
  }

  /**
   * Converts grey scale using the value component.
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] turnValueGreyScale() {
    return new Pixel[0][];
  }

  /**
   * Converts grey scale using the luma component.
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] turnLumaGreyScale() {
    return new Pixel[0][];
  }

  /**
   * Converts grey scale using the intensity component
   *
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] turnIntensityGreyScale() {
    return new Pixel[0][];
  }

  /**
   * Changes brightness of an image with a value representing how much to brighten (+ or -) amount
   *
   * @param value
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  @Override
  public Pixel[][] changeBrightness(int value) {
    return new Pixel[0][];
  }
}


