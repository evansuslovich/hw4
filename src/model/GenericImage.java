
package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GenericImage extends AbstractImage implements ImageInterface {

  private Pixel[][] image;
  private int width;
  private int height;


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

  public void saveImage(String pathName) {
    BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);

    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        int red = this.image[x][y].getPixel()[0];
        int green = this.image[x][y].getPixel()[1];
        int blue = this.image[x][y].getPixel()[2];

        Color color = new Color(red, green, blue);

        img.setRGB(x, y, color.getRGB());
      }
    }
    File outputFile = new File(pathName);
    String formatName = getFileFormat(pathName);
    try {
      ImageIO.write(img, formatName, outputFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

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

  public Pixel[][] getImage() {
    return image;
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


